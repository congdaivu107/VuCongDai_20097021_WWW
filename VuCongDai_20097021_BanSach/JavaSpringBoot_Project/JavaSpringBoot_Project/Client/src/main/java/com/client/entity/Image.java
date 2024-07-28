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
public class Image implements Serializable{
    private int idImage;
    private Sach sah;
    private String photo;

    public Image() {
    }
    
    public String getPhotosImagePath() {
        if (photo == null || idImage == 0) {
            return null;
        }
        return "/Image-BaiTapLon/" + idImage + "/" + photo;
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
        return "Image{" + "idPhoto=" + getPhotosImagePath() + '}';
    }
    
    
}
