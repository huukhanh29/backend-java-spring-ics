package com.backend.spring.controller;

import com.backend.spring.entity.GoiNangCap;
import com.backend.spring.entity.NhatKyNangCap;
import com.backend.spring.payload.request.NhatKyDto;
import com.backend.spring.payload.response.MessageResponse;
import com.backend.spring.repository.GoiNangCapRepository;
import com.backend.spring.repository.NhatKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/nhatky")
public class NhatKyController {
    @Autowired
    private NhatKyRepository nhatKyRepository;
    @Autowired
    private GoiNangCapRepository goiNangCapRepository;

    @GetMapping
    public ResponseEntity<List<NhatKyNangCap>> getAllNhatKy() {
        List<NhatKyNangCap> nhatKyList = nhatKyRepository.findAll();
        return new ResponseEntity<>(nhatKyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhatKyNangCap> getNhatKyById(@PathVariable Integer id) {
        Optional<NhatKyNangCap> nhatKyOptional = nhatKyRepository.findById(id);
        if (nhatKyOptional.isPresent()) {
            NhatKyNangCap nhatKy = nhatKyOptional.get();
            return new ResponseEntity<>(nhatKy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createNhatKy(@RequestBody NhatKyDto nhatKyDto) {
        Optional<GoiNangCap> goiNangCapOptional = goiNangCapRepository.findById(nhatKyDto.getGoiNangCapId());
        if (goiNangCapOptional.isPresent()) {
            GoiNangCap goiNangCap = goiNangCapOptional.get();

            NhatKyNangCap nhatKy = new NhatKyNangCap();
            nhatKy.setThoiDiemNangCap(nhatKyDto.getThoiDiemNangCap());
            nhatKy.setGoiNangCap(goiNangCap);
            nhatKy.setNguoiNangCap(nhatKyDto.getNguoiNangCap());
            nhatKy.setTrangThai(nhatKyDto.getTrangThai());
            nhatKy.setThoiDiemNhanLenh(nhatKyDto.getThoiDiemNhanLenh());
            nhatKy.setThoiDiemTcTb(nhatKyDto.getThoiDiemTcTb());
            nhatKy.setLyDo(nhatKyDto.getLyDo());

            NhatKyNangCap createdNhatKy = nhatKyRepository.save(nhatKy);
            return ResponseEntity.ok(new MessageResponse("Add successfully!"));
        } else {
            return new ResponseEntity<>(new MessageResponse("Error"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhatKyNangCap> updateNhatKy(@PathVariable Integer id, @RequestBody NhatKyDto nhatKyDto) {
        Optional<NhatKyNangCap> nhatKyOptional = nhatKyRepository.findById(id);
        if (nhatKyOptional.isPresent()) {
            NhatKyNangCap existingNhatKy = nhatKyOptional.get();

            Optional<GoiNangCap> goiNangCapOptional = goiNangCapRepository.findById(nhatKyDto.getGoiNangCapId());
            if (goiNangCapOptional.isPresent()) {
                GoiNangCap goiNangCap = goiNangCapOptional.get();

                existingNhatKy.setThoiDiemNangCap(nhatKyDto.getThoiDiemNangCap());
                existingNhatKy.setGoiNangCap(goiNangCap);
                existingNhatKy.setNguoiNangCap(nhatKyDto.getNguoiNangCap());
                existingNhatKy.setTrangThai(nhatKyDto.getTrangThai());
                existingNhatKy.setThoiDiemNhanLenh(nhatKyDto.getThoiDiemNhanLenh());
                existingNhatKy.setThoiDiemTcTb(nhatKyDto.getThoiDiemTcTb());
                existingNhatKy.setLyDo(nhatKyDto.getLyDo());

                NhatKyNangCap updatedNhatKy = nhatKyRepository.save(existingNhatKy);
                return new ResponseEntity<>(updatedNhatKy, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhatKy(@PathVariable Integer id) {
        Optional<NhatKyNangCap> nhatKyOptional = nhatKyRepository.findById(id);
        if (nhatKyOptional.isPresent()) {
            nhatKyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
