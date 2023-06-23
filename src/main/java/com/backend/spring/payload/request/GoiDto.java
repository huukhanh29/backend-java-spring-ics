package com.backend.spring.payload.request;

public class GoiDto {
    private Integer id;
    private String tenGoi;
    private String noiLuu;
    private String moTa;
    private String phienBan;
    private Integer nenTangId;

    // getters and setters

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

    public Integer getNenTangId() {
        return nenTangId;
    }

    public void setNenTangId(Integer nenTangId) {
        this.nenTangId = nenTangId;
    }
}
