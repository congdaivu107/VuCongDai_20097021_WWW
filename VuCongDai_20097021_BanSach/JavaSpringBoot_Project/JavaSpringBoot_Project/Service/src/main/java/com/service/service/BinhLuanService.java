/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.BinhLuanDAO;
import com.service.entity.BinhLuan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class BinhLuanService implements BinhLuanInterface{
    
    @Autowired
    private BinhLuanDAO dao;

    @Override
    public BinhLuan getBinhLuan(int id) {
        return dao.getBinhLuan(id);
    }

    @Override
    public void saveBinhLuan(BinhLuan binhLuan) {
        dao.saveBinhLuan(binhLuan);
    }

    @Override
    public void deleteBinhLuan(BinhLuan binhLuan) {
        dao.deleteBinhLuan(binhLuan);
    }

    @Override
    public List<BinhLuan> getLitBinhLuan() {
        return dao.getLitBinhLuan();
    }
    
}
