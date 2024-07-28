/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.SachDAO;
import com.service.entity.Sach;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class SachService implements SachInterface{
    
    @Autowired
    private SachDAO dao;

    @Override
    public List<Sach> getListSach() {
        return dao.getListSach();
    }

    @Override
    public Sach getSach(int id) {
        return dao.getSach(id);
    }

    @Override
    public Sach saveSach(Sach s) {
        return dao.saveSach(s);
    }

    @Override
    public void deleteSach(Sach sach) {
        dao.deleteSach(sach);
    }

    @Override
    public List<Sach> getListSach(String q) {
        return dao.getListSach(q);
    }
    
}
