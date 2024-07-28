/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.KhachHangDAO;
import com.service.entity.KhachHang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class KhachHangService implements KhachHangServiceInterface{
    
    @Autowired
    private KhachHangDAO dao;

    @Override
    public List<KhachHang> getListKhachHang() {
        return dao.getListKhachHang();
    }

    @Override
    public KhachHang getKhachHang(int id) {
        return dao.getKhachHang(id);
    }

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return dao.saveKhachHang(khachHang);
    }

    @Override
    public void deleteKhachHang(KhachHang khachHang) {
        dao.deleteKhachHang(khachHang);
    }

    @Override
    public KhachHang getKhachHangByTaiKhoan(String user) {
        return dao.getKhachHangByTaiKhoan(user);
    }
    
}
