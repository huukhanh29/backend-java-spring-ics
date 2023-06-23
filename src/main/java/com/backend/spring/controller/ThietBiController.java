package com.backend.spring.controller;

import com.backend.spring.entity.ThietBi;
import com.backend.spring.repository.ThietBiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/thietbi")
public class ThietBiController {
    @Autowired
    private ThietBiRepository thietBiRepository;

    @GetMapping
    public ResponseEntity<List<ThietBi>> getAllThietBi() {
        List<ThietBi> thietBiList = thietBiRepository.findAll();
        return new ResponseEntity<>(thietBiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThietBi> getThietBiById(@PathVariable Integer id) {
        Optional<ThietBi> thietBiOptional = thietBiRepository.findById(id);
        if (thietBiOptional.isPresent()) {
            ThietBi thietBi = thietBiOptional.get();
            return new ResponseEntity<>(thietBi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
