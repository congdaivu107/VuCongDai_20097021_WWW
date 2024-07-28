/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author longt
 */
@Entity
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Boolean active;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate birthDate;
    private int phone;    

    @JsonIgnore
    @OneToMany(mappedBy = "maKhachHang")
    private List<GioHang> gioHang;

    @JsonIgnore
    @OneToMany(mappedBy = "khachHang")
    private List<TaiKhoan> dstaiKhoan;
    
    @JsonIgnore
    @OneToMany(mappedBy = "khahHang", cascade = CascadeType.ALL)
    private List<Photo> listPhoto;

    public KhachHang() {
        this.listPhoto = new ArrayList<>();
        this.gioHang = new ArrayList<>();
        this.dstaiKhoan = new ArrayList<>();
    }

    public KhachHang(String firstName, String lastName, String email, String address, Boolean active, LocalDate birthDate, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = active;
        this.birthDate = birthDate;
        this.phone = phone;
        this.listPhoto = new ArrayList<>();
        this.gioHang = new ArrayList<>();
        this.dstaiKhoan = new ArrayList<>();
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
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
