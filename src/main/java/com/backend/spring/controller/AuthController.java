package com.backend.spring.controller;

import com.backend.spring.entity.TaiKhoan;
import com.backend.spring.payload.request.LoginRequest;
import com.backend.spring.payload.request.SignupRequest;
import com.backend.spring.payload.response.JwtResponse;
import com.backend.spring.payload.response.MessageResponse;
import com.backend.spring.repository.TaiKhoanRepository;
import com.backend.spring.security.jwt.JwtUtils;
import com.backend.spring.service.UserDetailsImpl;
import com.backend.spring.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  TaiKhoanRepository taiKhoanRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  UserDetailsServiceImpl userService;
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Optional<TaiKhoan> taiKhoan = userService.getByTaiKhoan(loginRequest.getTaikhoan());
    if (!taiKhoanRepository.existsByTaiKhoan(loginRequest.getTaikhoan())) {
      return new ResponseEntity<>(new MessageResponse("INVALID_USERNAME"), HttpStatus.BAD_REQUEST);
    }
    //tạo chuỗi mật khẩu cộng với ngayTao trong TaiKhoan
    String matKhau = loginRequest.getMatkhau() +
            taiKhoan.get().getNgayTao().toLocalDate().toString();
    //kiểm tra mật khẩu
    if (!encoder.matches(matKhau, taiKhoan.get().getMatKhau())) {
      return new ResponseEntity<>(new MessageResponse("INVALID_PASSWORD"), HttpStatus.BAD_REQUEST);
    }

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getTaikhoan(), matKhau));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUuid(),
            userDetails.getUsername()));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (taiKhoanRepository.existsByTaiKhoan(signUpRequest.getTaikhoan())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }
    // Lấy thời gian hiện tại
    LocalDate ngayHienTai = LocalDate.now();

    // Cộng chuỗi thời gian hiện tại với mật khẩu
    String matKhau = signUpRequest.getMatkhau() + ngayHienTai.toString();
    // Tạo tài khoản mới
    TaiKhoan user = new TaiKhoan(signUpRequest.getTaikhoan(),signUpRequest.getHoten(),
            encoder.encode(matKhau));

    taiKhoanRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

}
