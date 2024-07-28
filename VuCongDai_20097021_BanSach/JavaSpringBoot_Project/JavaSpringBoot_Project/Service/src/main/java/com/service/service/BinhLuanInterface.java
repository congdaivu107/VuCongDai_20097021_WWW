/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.entity.BinhLuan;
import java.util.List;

/**
 *
 * @author longt
 */
public interface BinhLuanInterface {
    public List<BinhLuan> getLitBinhLuan();

    public BinhLuan getBinhLuan(int id);

    public void saveBinhLuan(BinhLuan binhLuan);

    public void deleteBinhLuan(BinhLuan binhLuan);
}
