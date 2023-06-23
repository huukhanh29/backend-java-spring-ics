package com.backend.spring.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "NEN_TANG")
public class NenTang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tenNenTang;

    private String donViSanXuat;

    private String phienBan;

    public NenTang(Integer id, String tenNenTang, String donViSanXuat, String phienBan) {
        this.id = id;
        this.tenNenTang = tenNenTang;
        this.donViSanXuat = donViSanXuat;
        this.phienBan = phienBan;
    }

    public NenTang() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNenTang() {
        return tenNenTang;
    }

    public void setTenNenTang(String tenNenTang) {
        this.tenNenTang = tenNenTang;
    }

    public String getDonViSanXuat() {
        return donViSanXuat;
    }

    public void setDonViSanXuat(String donViSanXuat) {
        this.donViSanXuat = donViSanXuat;
    }

    public String getPhienBan() {
        return phienBan;
    }

    public void setPhienBan(String phienBan) {
        this.phienBan = phienBan;
    }
}
