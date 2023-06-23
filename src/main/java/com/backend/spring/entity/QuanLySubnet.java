package com.backend.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quan_ly_subnet")
public class QuanLySubnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String diaChiIp;

    private String moTa;

    public QuanLySubnet() {
    }

    public QuanLySubnet(int id, String diaChiIp, String moTa) {
        this.id = id;
        this.diaChiIp = diaChiIp;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaChiIp() {
        return diaChiIp;
    }

    public void setDiaChiIp(String diaChiIp) {
        this.diaChiIp = diaChiIp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
