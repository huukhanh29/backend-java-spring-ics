package com.backend.spring.service;

import com.backend.spring.entity.TaiKhoan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(name = "TAI_KHOAN")
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @Column(nullable = false)
    private String taiKhoan;

    @Column(nullable = false)
    private String matKhau;

    private String hoTen;

    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ngayTao;

    @JsonIgnore
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(Integer uuid, String taiKhoan, String matKhau, String hoTen, LocalDateTime ngayTao,
                           GrantedAuthority authority) {
        this.uuid = uuid;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngayTao = ngayTao;
        this.authorities = Collections.singleton(authority);
    }

    public static UserDetailsImpl build(TaiKhoan taiKhoan) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        return new UserDetailsImpl(
                taiKhoan.getUuid(),
                taiKhoan.getTaiKhoan(),
                taiKhoan.getMatKhau(),
                taiKhoan.getHoTen(),
                taiKhoan.getNgayTao(),
                authority
        );
    }

    public Integer getUuid() {
        return uuid;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return taiKhoan;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(uuid, user.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
