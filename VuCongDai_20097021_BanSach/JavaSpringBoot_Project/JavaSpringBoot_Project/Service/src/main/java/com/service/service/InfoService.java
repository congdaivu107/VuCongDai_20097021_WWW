/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.InfoDAO;
import com.service.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class InfoService {
    
    @Autowired
    private InfoDAO dao;

    public void saveInfo(int maSach,String string) {
        dao.saveInfo(maSach,string);
    }

    public Sach getLastBook() {
        return dao.getLastBook();
    }

    public void deleteSach(int maSach) {
        dao.deleteSach(maSach);
    }
    
}
