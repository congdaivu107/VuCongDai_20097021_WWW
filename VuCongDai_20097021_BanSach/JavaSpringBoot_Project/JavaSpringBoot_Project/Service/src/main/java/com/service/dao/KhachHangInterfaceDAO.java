/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.KhachHang;
import java.util.List;

/**
 *
 * @author longt
 */
public interface KhachHangInterfaceDAO {

    public List<KhachHang> getListKhachHang();

    public KhachHang getKhachHang(int id);

    public KhachHang saveKhachHang(KhachHang khachHang);

    public void deleteKhachHang(KhachHang khachHang);
    
    public KhachHang getKhachHangByTaiKhoan(String user);
}
