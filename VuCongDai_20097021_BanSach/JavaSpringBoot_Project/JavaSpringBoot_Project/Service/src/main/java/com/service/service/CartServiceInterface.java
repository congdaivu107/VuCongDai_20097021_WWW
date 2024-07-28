/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.entity.GioHang;
import java.util.List;

/**
 *
 * @author longt
 */
public interface CartServiceInterface {

    public List<GioHang> getListGioHang();

    public List<GioHang> getGioHang(int id);

    public void saveGioHang(GioHang gh);

    public void deleteGioHang(GioHang gh);
    
    public void deleteGioHang(int maSach);
    
    public GioHang getGioHang(int id, int maSach);
}
