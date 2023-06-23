package com.backend.spring.repository;

import com.backend.spring.entity.QuanLySubnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuanLySubnetRepository extends JpaRepository<QuanLySubnet, Integer> {


}

