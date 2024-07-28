/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.entity;

/**
 *
 * @author longt
 */
public class BinhLuan {
    private int maBinhLuan;
    private String tenNguoi;
    private String noiDung;
    private Sach sach;

    public BinhLuan() {
    }

    public BinhLuan(String tenNguoi, String noiDung, Sach sach) {
        this.tenNguoi = tenNguoi;
        this.noiDung = noiDung;
        this.sach = sach;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getMaBinhLuan() {
        return maBinhLuan;
    }

    public void setMaBinhLuan(int maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    public String getTenNguoi() {
        return tenNguoi;
    }

    public void setTenNguoi(String tenNguoi) {
        this.tenNguoi = tenNguoi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Override
    public String toString() {
        return "BinhLuan{" + "maBinhLuan=" + maBinhLuan + ", tenNguoi=" + tenNguoi + ", noiDung=" + noiDung + '}';
    }
    
    
}
