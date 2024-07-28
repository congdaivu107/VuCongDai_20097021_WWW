/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author longt
 */
@Entity
public class TaiKhoan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTaiKhoan;
    private String taiKhoan;
    private String password;
    private boolean status;
    private String role;
    
    @ManyToOne
    @JoinColumn(name="maKhachHang", nullable=false)
    private KhachHang khachHang;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String password, boolean status, String role, KhachHang khachHang) {
        this.taiKhoan = taiKhoan;
        this.password = password;
        this.status = status;
        this.role = role;
        this.khachHang = khachHang;
    }

    

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "idTaiKhoan=" + idTaiKhoan + ", taiKhoan=" + taiKhoan + ", password=" + password + ", status=" + status + ", role=" + role + '}';
    }
    
    
}
