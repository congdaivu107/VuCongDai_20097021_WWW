/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author longt
 */
@Embeddable
public class GioHang_PK implements Serializable {
    private int maKhachHang;
    private int maSach;

    public GioHang_PK() {
    }

    public GioHang_PK(int maKhachHang, int maSach) {
        this.maKhachHang = maKhachHang;
        this.maSach = maSach;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.maKhachHang;
        hash = 11 * hash + this.maSach;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GioHang_PK other = (GioHang_PK) obj;
        if (this.maKhachHang != other.maKhachHang) {
            return false;
        }
        if (this.maSach != other.maSach) {
            return false;
        }
        return true;
    }
    
    
}
