/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.model;

import com.client.entity.GioHang;
import com.client.entity.Image;

/**
 *
 * @author longt
 */
public class ItemCart {
    private GioHang gioHang;
    private Image image;

    public ItemCart(GioHang gioHang, Image image) {
        this.gioHang = gioHang;
        this.image = image;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemCart{" + "gioHang=" + gioHang + ", image=" + image + '}';
    }
    
    
    
}
