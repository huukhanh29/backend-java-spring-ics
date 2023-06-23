package com.backend.spring.payload.request;

import com.backend.spring.entity.ETrangThai;

import java.time.LocalDateTime;

public class NhatKyDto {
    private LocalDateTime thoiDiemNangCap;
    private Integer goiNangCapId;
    private String nguoiNangCap;
    private ETrangThai trangThai;
    private LocalDateTime thoiDiemNhanLenh;
    private LocalDateTime thoiDiemTcTb;
    private String lyDo;

    public LocalDateTime getThoiDiemNangCap() {
        return thoiDiemNangCap;
    }

    public void setThoiDiemNangCap(LocalDateTime thoiDiemNangCap) {
        this.thoiDiemNangCap = thoiDiemNangCap;
    }

    public Integer getGoiNangCapId() {
        return goiNangCapId;
    }

    public void setGoiNangCapId(Integer goiNangCapId) {
        this.goiNangCapId = goiNangCapId;
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
