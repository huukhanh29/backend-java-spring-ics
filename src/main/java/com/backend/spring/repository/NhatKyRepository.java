package com.backend.spring.repository;

import com.backend.spring.entity.NhatKyNangCap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhatKyRepository extends JpaRepository<NhatKyNangCap, Integer> {

}