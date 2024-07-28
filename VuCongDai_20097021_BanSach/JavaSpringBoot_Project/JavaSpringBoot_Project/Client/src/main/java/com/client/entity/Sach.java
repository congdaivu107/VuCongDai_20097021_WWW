/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author longt
 */
public class Sach {

    private int maSach;
    private String tenSach;
    private double giaSach;
    private double danhGia;
    private List<BinhLuan> listBinhLuan;

    private String tacGia;
    private String mieuTa;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate ngayXuatBang;
    private Set<String> thongTinThem;
    private List<String> listPhoto;
    private List<GioHang> dsKhachHang;

    public Sach() {
        this.listBinhLuan = new ArrayList<>();
        this.listPhoto = new ArrayList<>();
        this.thongTinThem = new HashSet<>();
    }

    public Sach(String tenSach, double giaSach, double danhGia, String tacGia, String mieuTa, LocalDate ngayXuatBang) {
        this.tenSach = tenSach;
        this.giaSach = giaSach;
        this.danhGia = danhGia;
        this.tacGia = tacGia;
        this.mieuTa = mieuTa;
        this.ngayXuatBang = ngayXuatBang;
        this.listBinhLuan = new ArrayList<>();
        this.listPhoto = new ArrayList<>();
        this.thongTinThem = new HashSet<>();
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }

    public double getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(double danhGia) {
        this.danhGia = danhGia;
    }

    public List<BinhLuan> getListBinhLuan() {
        return listBinhLuan;
    }

    public void setListBinhLuan(List<BinhLuan> listBinhLuan) {
        this.listBinhLuan = listBinhLuan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public LocalDate getNgayXuatBang() {
        return ngayXuatBang;
    }

    public void setNgayXuatBang(LocalDate ngayXuatBang) {
        this.ngayXuatBang = ngayXuatBang;
    }

    public Set<String> getThongTinThem() {
        return thongTinThem;
    }

    public void setThongTinThem(Set<String> thongTinThem) {
        this.thongTinThem = thongTinThem;
    }

    public List<String> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(List<String> listPhoto) {
        this.listPhoto = listPhoto;
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", giaSach=" + giaSach + ", danhGia=" + danhGia + ", listBinhLuan=" + listBinhLuan + ", tacGia=" + tacGia + ", mieuTa=" + mieuTa + ", ngayXuatBang=" + ngayXuatBang + ", thongTinThem=" + thongTinThem + ", listPhoto=" + listPhoto + '}';
    }

}
