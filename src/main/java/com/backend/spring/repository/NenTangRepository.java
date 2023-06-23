package com.backend.spring.repository;


import com.backend.spring.entity.NenTang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NenTangRepository extends JpaRepository<NenTang, Integer> {

}