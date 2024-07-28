/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.GioHangDAO;
import com.service.entity.GioHang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class CartService implements CartServiceInterface{

    @Autowired
    private GioHangDAO dao;
    
    @Override
    public List<GioHang> getListGioHang() {
        return dao.getListGioHang();
    }

    @Override
    public List<GioHang> getGioHang(int id) {
        return dao.getGioHang(id);
    }

    @Override
    public void saveGioHang(GioHang gh) {
        dao.saveGioHang(gh);
    }

    @Override
    public void deleteGioHang(GioHang gh) {
        dao.deleteGioHang(gh);
    }
    
    @Override
    public void deleteGioHang(int maSach) {
        dao.deleteGioHang(maSach);
    }

    @Override
    public GioHang getGioHang(int id, int maSach) {
        return dao.getGioHang(id,maSach);
    }
    
}
