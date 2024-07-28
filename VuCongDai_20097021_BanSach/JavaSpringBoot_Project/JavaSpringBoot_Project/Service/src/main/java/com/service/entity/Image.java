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
public class Image implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImage;
    
    @ManyToOne
    @JoinColumn(name="maSach", nullable=false)
    private Sach sah;
    
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String photo;

    public Image() {
    }

    public Image(Sach sah, String photo) {
        this.sah = sah;
        this.photo = photo;
    }

    public int getIdPhoto() {
        return idImage;
    }

    public void setIdPhoto(int idPhoto) {
        this.idImage = idPhoto;
    }

    public Sach getSah() {
        return sah;
    }

    public void setSah(Sach sah) {
        this.sah = sah;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Image{" + "idPhoto=" + idImage + ", sah=" + sah + ", photo=" + photo + '}';
    }
    
    
}
