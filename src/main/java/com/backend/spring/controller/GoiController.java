package com.backend.spring.controller;
import com.backend.spring.entity.GoiNangCap;

import com.backend.spring.entity.NenTang;
import com.backend.spring.payload.request.GoiDto;
import com.backend.spring.payload.response.MessageResponse;
import com.backend.spring.repository.GoiNangCapRepository;
import com.backend.spring.repository.NenTangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/goi")
public class GoiController {
    @Autowired
    private GoiNangCapRepository goiNangCapRepository;
    @Autowired
    private  NenTangRepository nenTangRepository;
    @GetMapping
    public ResponseEntity<List<GoiNangCap>> getAllGoiNangCap() {
        List<GoiNangCap> goiList = goiNangCapRepository.findAll();
        return new ResponseEntity<>(goiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoiNangCap> getGoiNangCapById(@PathVariable Integer id) {
        Optional<GoiNangCap> goiOptional = goiNangCapRepository.findById(id);
        if (goiOptional.isPresent()) {
            GoiNangCap goiNangCap = goiOptional.get();
            return new ResponseEntity<>(goiNangCap, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createGoiNangCap(@RequestBody GoiDto goiDto) {

        Optional<NenTang> nenTangOptional = nenTangRepository.findById(goiDto.getNenTangId());
        if (nenTangOptional.isPresent()) {
            NenTang nenTang = nenTangOptional.get();

            GoiNangCap goiNangCap = new GoiNangCap();
            goiNangCap.setTenGoi(goiDto.getTenGoi());
            goiNangCap.setNoiLuu(goiDto.getNoiLuu());
            goiNangCap.setMoTa(goiDto.getMoTa());
            goiNangCap.setPhienBan(goiDto.getPhienBan());
            goiNangCap.setNenTang(nenTang);

            GoiNangCap createdGoiNangCap = goiNangCapRepository.save(goiNangCap);
            return ResponseEntity.ok(new MessageResponse("Add successfully!"));
        } else {
            return new ResponseEntity<>(new MessageResponse("Error"), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoiNangCap(@PathVariable Integer id) {
        Optional<GoiNangCap> goiOptional = goiNangCapRepository.findById(id);
        if (goiOptional.isPresent()) {
            goiNangCapRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Delete successfully!"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGoiNangCap(@PathVariable Integer id, @RequestBody GoiDto goiDto) {
        Optional<GoiNangCap> goiOptional = goiNangCapRepository.findById(id);
        Optional<NenTang> nenTangOptional = nenTangRepository.findById(goiDto.getNenTangId());
        if (goiOptional.isPresent() && nenTangOptional.isPresent()) {
            GoiNangCap goiNangCap = goiOptional.get();
            NenTang nenTang = nenTangOptional.get();

            goiNangCap.setTenGoi(goiDto.getTenGoi());
            goiNangCap.setNoiLuu(goiDto.getNoiLuu());
            goiNangCap.setMoTa(goiDto.getMoTa());
            goiNangCap.setPhienBan(goiDto.getPhienBan());
            goiNangCap.setNenTang(nenTang);

            goiNangCapRepository.save(goiNangCap);
            return ResponseEntity.ok(new MessageResponse("Update successfully!"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

