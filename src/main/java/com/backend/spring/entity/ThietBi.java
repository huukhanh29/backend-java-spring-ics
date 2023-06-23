package com.backend.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "thiet_bi")
public class ThietBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String ten;

    private String serial;

    private String mac;

    private String kinhDo;

    private String viDo;

    private String donViHanhChinh;

    private String soDienThoai;

    private String soLoa;

    private String ghiChu;

    private String maModelThietBi;

    private String maLoaiThietBi;


    public ThietBi() {
    }

    public ThietBi(Integer id, String ten, String serial, String mac, String kinhDo, String viDo, String donViHanhChinh, String soDienThoai, String soLoa, String ghiChu, String maModelThietBi, String maLoaiThietBi) {
        this.id = id;
        this.ten = ten;
        this.serial = serial;
        this.mac = mac;
        this.kinhDo = kinhDo;
        this.viDo = viDo;
        this.donViHanhChinh = donViHanhChinh;
        this.soDienThoai = soDienThoai;
        this.soLoa = soLoa;
        this.ghiChu = ghiChu;

        this.maModelThietBi = maModelThietBi;
        this.maLoaiThietBi = maLoaiThietBi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(String kinhDo) {
        this.kinhDo = kinhDo;
    }

    public String getViDo() {
        return viDo;
    }

    public void setViDo(String viDo) {
        this.viDo = viDo;
    }

    public String getDonViHanhChinh() {
        return donViHanhChinh;
    }

    public void setDonViHanhChinh(String donViHanhChinh) {
        this.donViHanhChinh = donViHanhChinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoLoa() {
        return soLoa;
    }

    public void setSoLoa(String soLoa) {
        this.soLoa = soLoa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaModelThietBi() {
        return maModelThietBi;
    }

    public void setMaModelThietBi(String maModelThietBi) {
        this.maModelThietBi = maModelThietBi;
    }

    public String getMaLoaiThietBi() {
        return maLoaiThietBi;
    }

    public void setMaLoaiThietBi(String maLoaiThietBi) {
        this.maLoaiThietBi = maLoaiThietBi;
    }
}
