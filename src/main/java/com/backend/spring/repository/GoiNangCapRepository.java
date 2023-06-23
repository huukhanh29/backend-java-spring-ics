package com.backend.spring.repository;

import com.backend.spring.entity.GoiNangCap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoiNangCapRepository extends JpaRepository<GoiNangCap, Integer> {

}
