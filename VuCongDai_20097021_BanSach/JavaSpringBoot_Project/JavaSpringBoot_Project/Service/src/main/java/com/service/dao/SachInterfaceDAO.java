/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.Sach;
import java.util.List;

/**
 *
 * @author longt
 */
public interface SachInterfaceDAO {

    public List<Sach> getListSach();

    public Sach getSach(int id);

    public Sach saveSach(Sach s);

    public void deleteSach(Sach sach);

    public List<Sach> getListSach(String q);
}
