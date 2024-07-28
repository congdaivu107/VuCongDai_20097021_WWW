/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.entity;

import java.io.Serializable;
import javax.persistence.Column;
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
public class Photo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhoto;
    
    @ManyToOne
    @JoinColumn(name="maKhachHang", nullable=false)
    private KhachHang khahHang;
    
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String photo;

    public Photo() {
    }

    public Photo(KhachHang khahHang, String photo) {
        this.khahHang = khahHang;
        this.photo = photo;
    }    

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public KhachHang getKhahHang() {
        return khahHang;
    }

    public void setKhahHang(KhachHang khahHang) {
        this.khahHang = khahHang;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Photo{" + "idPhoto=" + idPhoto + ", khahHang=" + khahHang + ", photo=" + photo + '}';
    }
    
    
}
