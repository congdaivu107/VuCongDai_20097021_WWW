/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.entity;

import java.io.Serializable;

/**
 *
 * @author longt
 */
public class TaiKhoan implements Serializable {

    private int idTaiKhoan;
    private String taiKhoan;
    private String password;
    private boolean status;
    private String role;
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

    

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
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

    

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getUser() {
        return taiKhoan;
    }

    public void setUser(String user) {
        this.taiKhoan = user;
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

    @Override
    public String toString() {
        return "TaiKhoan{" + "idTaiKhoan=" + idTaiKhoan + ", user=" + taiKhoan + ", password=" + password + ", status=" + status + '}';
    }

}
