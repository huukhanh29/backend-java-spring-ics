package com.backend.spring.payload.response;

import java.util.List;

public class JwtResponse {
  private String accessToken;
  private String tokenType = "Bearer";
  private Integer uuid;
  private String taiKhoan;


  public JwtResponse(String accessToken, Integer uuid, String taiKhoan) {
    this.accessToken = accessToken;
    this.uuid = uuid;
    this.taiKhoan = taiKhoan;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public Integer getUuid() {
    return uuid;
  }

  public void setUuid(Integer uuid) {
    this.uuid = uuid;
  }


  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
  }

}
