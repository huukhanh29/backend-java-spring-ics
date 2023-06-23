package com.backend.spring.controller;

import com.backend.spring.entity.GoiNangCap;
import com.backend.spring.entity.NenTang;
import com.backend.spring.entity.NhatKyNangCap;
import com.backend.spring.payload.request.NhatKyDto;
import com.backend.spring.payload.response.MessageResponse;
import com.backend.spring.repository.GoiNangCapRepository;
import com.backend.spring.repository.NenTangRepository;
import com.backend.spring.repository.NhatKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/nentang")
public class NenTangController {
    @Autowired
    private NenTangRepository nenTangRepository;

    @GetMapping
    public ResponseEntity<List<NenTang>> getAllNenTang() {
        List<NenTang> nenTangList = nenTangRepository.findAll();
        return new ResponseEntity<>(nenTangList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NenTang> getNenTangById(@PathVariable Integer id) {
        Optional<NenTang> nenTangOptional = nenTangRepository.findById(id);
        if (nenTangOptional.isPresent()) {
            NenTang nenTang = nenTangOptional.get();
            return new ResponseEntity<>(nenTang, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createNenTang(@RequestBody NenTang nenTang) {
        NenTang createdNenTang = nenTangRepository.save(nenTang);
        return ResponseEntity.ok(new MessageResponse("Add successfully!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNenTang(@PathVariable Integer id, @RequestBody NenTang nenTang) {
        Optional<NenTang> nenTangOptional = nenTangRepository.findById(id);
        if (nenTangOptional.isPresent()) {
            NenTang existingNenTang = nenTangOptional.get();
            existingNenTang.setTenNenTang(nenTang.getTenNenTang());
            existingNenTang.setDonViSanXuat(nenTang.getDonViSanXuat());
            existingNenTang.setPhienBan(nenTang.getPhienBan());

            nenTangRepository.save(existingNenTang);
            return ResponseEntity.ok(new MessageResponse("Update successfully!"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNenTang(@PathVariable Integer id) {
        Optional<NenTang> nenTangOptional = nenTangRepository.findById(id);
        if (nenTangOptional.isPresent()) {
            nenTangRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Delete successfully!"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
