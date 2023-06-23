package com.backend.spring.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "NHAT_KY_NANG_CAP")
public class NhatKyNangCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime thoiDiemNangCap;

    @ManyToOne
    @JoinColumn(name = "goi_nang_cap_id")
    private GoiNangCap goiNangCap;

    private String nguoiNangCap;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ETrangThai trangThai;

    private LocalDateTime thoiDiemNhanLenh;

    private LocalDateTime thoiDiemTcTb;

    @Column(columnDefinition = "TEXT")
    private String lyDo;

    public NhatKyNangCap() {
    }

    public NhatKyNangCap(Integer id, LocalDateTime thoiDiemNangCap,
                         GoiNangCap goiNangCap, String nguoiNangCap, ETrangThai trangThai,
                         LocalDateTime thoiDiemNhanLenh, LocalDateTime thoiDiemTcTb, String lyDo) {
        this.id = id;
        this.thoiDiemNangCap = thoiDiemNangCap;
        this.goiNangCap = goiNangCap;
        this.nguoiNangCap = nguoiNangCap;
        this.trangThai = trangThai;
        this.thoiDiemNhanLenh = thoiDiemNhanLenh;
        this.thoiDiemTcTb = thoiDiemTcTb;
        this.lyDo = lyDo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getThoiDiemNangCap() {
        return thoiDiemNangCap;
    }

    public void setThoiDiemNangCap(LocalDateTime thoiDiemNangCap) {
        this.thoiDiemNangCap = thoiDiemNangCap;
    }

    public GoiNangCap getGoiNangCap() {
        return goiNangCap;
    }

    public void setGoiNangCap(GoiNangCap goiNangCap) {
        this.goiNangCap = goiNangCap;
    }

    public String getNguoiNangCap() {
        return nguoiNangCap;
    }

    public void setNguoiNangCap(String nguoiNangCap) {
        this.nguoiNangCap = nguoiNangCap;
    }

    public ETrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(ETrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDateTime getThoiDiemNhanLenh() {
        return thoiDiemNhanLenh;
    }

    public void setThoiDiemNhanLenh(LocalDateTime thoiDiemNhanLenh) {
        this.thoiDiemNhanLenh = thoiDiemNhanLenh;
    }

    public LocalDateTime getThoiDiemTcTb() {
        return thoiDiemTcTb;
    }

    public void setThoiDiemTcTb(LocalDateTime thoiDiemTcTb) {
        this.thoiDiemTcTb = thoiDiemTcTb;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}