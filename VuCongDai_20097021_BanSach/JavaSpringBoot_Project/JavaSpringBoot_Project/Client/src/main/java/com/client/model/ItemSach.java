/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.model;

/**
 *
 * @author longt
 */
public class ItemSach {
    private int maSach;
    private int soLuong;

    public ItemSach() {
    }

    public ItemSach(int maSach, int soLuong) {
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
