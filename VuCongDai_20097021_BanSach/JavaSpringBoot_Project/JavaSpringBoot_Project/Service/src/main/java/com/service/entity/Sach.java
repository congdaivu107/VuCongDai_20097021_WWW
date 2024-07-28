/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author longt
 */
@Entity
public class Sach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSach;
    private String tenSach;
    private double giaSach;
    private double danhGia;

    @JsonManagedReference
    @OneToMany(mappedBy = "sach", cascade = CascadeType.ALL)
    private List<BinhLuan> listBinhLuan;

    private String tacGia;
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String mieuTa;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate ngayXuatBang;
    @ElementCollection
    @CollectionTable(name = "ThongTinKhac")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<String> thongTinThem;

    @JsonIgnore
    @OneToMany(mappedBy = "sah", cascade = CascadeType.ALL)
    private List<Image> listPhoto;

    @JsonIgnore
    @OneToMany(mappedBy = "maSach")
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

    public List<Image> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(List<Image> listPhoto) {
        this.listPhoto = listPhoto;
    }

    public List<GioHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(List<GioHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", giaSach=" + giaSach + ", danhGia=" + danhGia + ", listBinhLuan=" + listBinhLuan + ", tacGia=" + tacGia + ", mieuTa=" + mieuTa + ", ngayXuatBang=" + ngayXuatBang + '}';
    }    
}
