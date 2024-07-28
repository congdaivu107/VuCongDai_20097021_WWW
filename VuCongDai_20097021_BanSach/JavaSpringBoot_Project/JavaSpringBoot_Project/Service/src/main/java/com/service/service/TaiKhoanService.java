/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.TaiKhoanDAO;
import com.service.entity.TaiKhoan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author longt
 */
@Service
public class TaiKhoanService implements TaiKhoanServiceInterface{
    
    @Autowired
    private TaiKhoanDAO dao;

    @Override
    public List<TaiKhoan> getListTaiKhoan() {
        return dao.getListTaiKhoan();
    }

    @Override
    public TaiKhoan getTaiKhoan(int id) {
        return dao.getTaiKhoan(id);
    }

    @Override
    public TaiKhoan saveTaiKhoan(TaiKhoan taiKhoan) {
        return dao.saveTaiKhoan(taiKhoan);
    }

    @Override
    public void deleteTaiKhoan(TaiKhoan taiKhoan) {
        dao.deleteTaiKhoan(taiKhoan);
    }

    @Override
    public boolean checkTaiKhoan(String username) {
        return dao.checkTaiKhoan(username);
    }   
}
