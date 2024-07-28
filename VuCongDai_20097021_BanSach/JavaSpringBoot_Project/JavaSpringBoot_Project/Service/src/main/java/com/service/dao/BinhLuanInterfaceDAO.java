/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.BinhLuan;

/**
 *
 * @author longt
 */
public interface BinhLuanInterfaceDAO {

    public BinhLuan getBinhLuan(int id);

    public void saveBinhLuan(BinhLuan binhLuan);

    public void deleteBinhLuan(BinhLuan binhLuan);
}
