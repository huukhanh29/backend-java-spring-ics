package com.backend.spring.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "GOI_NANG_CAP")
public class GoiNangCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tenGoi;

    private String noiLuu;

    @Column(columnDefinition = "TEXT")
    private String moTa;

    private String phienBan;

    @ManyToOne
    @JoinColumn(name = "nen_tang_id")
    private NenTang nenTang;

    public GoiNangCap() {
    }

    public GoiNangCap(Integer id, String tenGoi, String noiLuu, String moTa, String phienBan, NenTang nenTang) {
        this.id = id;
        this.tenGoi = tenGoi;
        this.noiLuu = noiLuu;
        this.moTa = moTa;
        this.phienBan = phienBan;
        this.nenTang = nenTang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public String getNoiLuu() {
        return noiLuu;
    }

    public void setNoiLuu(String noiLuu) {
        this.noiLuu = noiLuu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getPhienBan() {
        return phienBan;
    }

    public void setPhienBan(String phienBan) {
        this.phienBan = phienBan;
    }

    public NenTang getNenTang() {
        return nenTang;
    }

    public void setNenTang(NenTang nenTang) {
        this.nenTang = nenTang;
    }
}
