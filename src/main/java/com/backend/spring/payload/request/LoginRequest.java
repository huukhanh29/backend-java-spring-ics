package com.backend.spring.payload.request;


import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  	private String taikhoan;

	@NotBlank
	private String matkhau;

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
}
