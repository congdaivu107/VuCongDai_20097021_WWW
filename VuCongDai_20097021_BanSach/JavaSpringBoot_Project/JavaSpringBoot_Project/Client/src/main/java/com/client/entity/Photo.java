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
public class Photo implements Serializable {

    private int idPhoto;
    private KhachHang khahHang;
    private String photo;
    
    public String getPhotosImagePath() {
        if (photo == null || idPhoto == 0) {
            return null;
        }
        return "/Photo-BaiTapLon/" + idPhoto + "/" + photo;
    }

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
