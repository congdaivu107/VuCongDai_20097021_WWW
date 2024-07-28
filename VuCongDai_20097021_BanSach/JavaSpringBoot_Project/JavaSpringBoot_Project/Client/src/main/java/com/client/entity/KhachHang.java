/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longt
 */
public class KhachHang implements Serializable {

    private int maKhachHang;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Boolean active;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate birthDate;
    private int phone;
    @JsonIgnore
    private List<Photo> listPhoto;

    private List<GioHang> gioHang;

    @JsonIgnore
    private List<TaiKhoan> dstaiKhoan;

    public KhachHang() {
        this.listPhoto = new ArrayList<>();
        this.gioHang = new ArrayList<>();
        this.dstaiKhoan = new ArrayList<>();
    }

    public KhachHang(String firstName, String lastName, String email, String address, LocalDate birthDate, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = true;
        this.birthDate = birthDate;
        this.phone = phone;
        this.listPhoto = new ArrayList<>();
        this.gioHang = new ArrayList<>();
        this.dstaiKhoan = new ArrayList<>();
    }

    public int getMaKhacHang() {
        return maKhachHang;
    }

    public void setMaKhacHang(int maKhacHang) {
        this.maKhachHang = maKhacHang;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<Photo> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(List<Photo> listPhoto) {
        this.listPhoto = listPhoto;
    }
    
    public List<GioHang> getGioHang() {
        return gioHang;
    }

    public void setGioHang(List<GioHang> gioHang) {
        this.gioHang = gioHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public List<TaiKhoan> getDstaiKhoan() {
        return dstaiKhoan;
    }

    public void setDstaiKhoan(List<TaiKhoan> dstaiKhoan) {
        this.dstaiKhoan = dstaiKhoan;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", active=" + active + ", birthDate=" + birthDate + ", phone=" + phone + '}';
    }

    
}
