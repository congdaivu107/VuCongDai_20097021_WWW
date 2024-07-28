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
public class GioHang implements Serializable {
    private KhachHang maKhachHang;
    private Sach maSach;
    
    private int SoLuong;
    private String ghiChu;

    public GioHang() {
    }

    public GioHang(KhachHang maKhachHang, Sach maSach, int SoLuong, String ghiChu) {
        this.maKhachHang = maKhachHang;
        this.maSach = maSach;
        this.SoLuong = SoLuong;
        this.ghiChu = ghiChu;
    }

    public KhachHang getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(KhachHang maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Sach getMaSach() {
        return maSach;
    }

    public void setMaSach(Sach maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "GioHang{" + "maKhachHang=" + maKhachHang + ", maSach=" + maSach + ", SoLuong=" + SoLuong + ", ghiChu=" + ghiChu + '}';
    }
    
    
}
