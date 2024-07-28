/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.TaiKhoan;
import java.util.List;

/**
 *
 * @author longt
 */
public interface TaiKhoanInterfaceDAO {

    public List<TaiKhoan> getListTaiKhoan();

    public TaiKhoan getTaiKhoan(int id);

    public TaiKhoan saveTaiKhoan(TaiKhoan taiKhoan);

    public void deleteTaiKhoan(TaiKhoan taiKhoan);
    
    public boolean checkTaiKhoan(String username);
}
