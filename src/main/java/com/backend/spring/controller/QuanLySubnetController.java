package com.backend.spring.controller;

import com.backend.spring.entity.QuanLySubnet;
import com.backend.spring.repository.QuanLySubnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/quanlysubnet")
public class QuanLySubnetController {
    @Autowired
    private QuanLySubnetRepository quanLySubnetRepository;

    @GetMapping
    public ResponseEntity<List<QuanLySubnet>> getAllQuanLySubnet() {
        List<QuanLySubnet> quanLySubnetList = quanLySubnetRepository.findAll();
        return new ResponseEntity<>(quanLySubnetList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuanLySubnet> getThietBiById(@PathVariable Integer id) {
        Optional<QuanLySubnet> quanLySubnetOptional = quanLySubnetRepository.findById(id);
        if (quanLySubnetOptional.isPresent()) {
            QuanLySubnet quanLySubnet = quanLySubnetOptional.get();
            return new ResponseEntity<>(quanLySubnet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
