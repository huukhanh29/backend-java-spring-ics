package com.backend.spring.repository;

import com.backend.spring.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findTaiKhoanByTaiKhoan(String taikhoan);

    Boolean existsByTaiKhoan(String taikhoan);

}
