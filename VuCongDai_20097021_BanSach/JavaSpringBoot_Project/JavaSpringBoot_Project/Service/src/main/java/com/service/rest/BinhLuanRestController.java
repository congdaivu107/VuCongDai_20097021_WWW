/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.exception.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.entity.BinhLuan;
import com.service.service.BinhLuanService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author longt
 */
@RestController
@RequestMapping("/api")
public class BinhLuanRestController {
    @Autowired
    private BinhLuanService service;
    
    @GetMapping("/books/comments")
    public List<BinhLuan> getListBinhLuan(){
        List<BinhLuan> list = null;
        list = service.getLitBinhLuan();
        return list;
    }
    
    @GetMapping("/books/comments/{id}")
    public BinhLuan getBinhLuan(@PathVariable int id){
        BinhLuan sach = service.getBinhLuan(id);
        if(sach == null){
            throw new CustomNotFoundException("Binh luan khong tim thay (maBL:"+id+")");
        }
        return sach;
    }
    
    @PostMapping("/books/comments")
    public BinhLuan addBinhLuan(@RequestBody BinhLuan binhLuan){
        binhLuan.setMaBinhLuan(0);
        service.saveBinhLuan(binhLuan);
        return binhLuan;
    }
    
    @PutMapping("/books/comments")
    public BinhLuan updateBinhLuan(@RequestBody BinhLuan binhLuan){
        service.saveBinhLuan(binhLuan);
        return binhLuan;
    }
    
    @DeleteMapping("/books/comments/{id}")
    public String deleteBinhLuan(@PathVariable int id){
        BinhLuan binhLuan = service.getBinhLuan(id);
        if(binhLuan == null)
            throw new CustomNotFoundException("Binh luan khong tim thay (maBL:"+id+")");
        service.deleteBinhLuan(binhLuan);
        return "Binh luan xoa thanh cong (ma:"+id+")";
    }
}
