/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.GioHang;
import java.util.List;

/**
 *
 * @author longt
 */
public interface GioHangInterfaceDAO {

    public List<GioHang> getListGioHang();

    public List<GioHang> getGioHang(int id);

    public void saveGioHang(GioHang gh);

    public void deleteGioHang(GioHang gh);
    
    public GioHang getGioHang(int id, int maSach);
    
    public void deleteGioHang(int maSach);
}
