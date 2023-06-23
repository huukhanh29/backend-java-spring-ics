package com.backend.spring.service;

import com.backend.spring.entity.TaiKhoan;
import com.backend.spring.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  TaiKhoanRepository taiKhoanRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String taikhoan) throws UsernameNotFoundException {
    TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByTaiKhoan(taikhoan)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + taikhoan));

    return UserDetailsImpl.build(taiKhoan);
  }
  public Optional<TaiKhoan> getByTaiKhoan(String taikhoan){
    return taiKhoanRepository.findTaiKhoanByTaiKhoan(taikhoan);
  }
}
