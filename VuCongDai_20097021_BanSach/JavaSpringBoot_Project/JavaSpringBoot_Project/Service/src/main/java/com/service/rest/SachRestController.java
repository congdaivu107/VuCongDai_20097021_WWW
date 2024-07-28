/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.entity.Sach;
import com.service.exception.CustomNotFoundException;
import com.service.service.CartService;
import com.service.service.InfoService;
import com.service.service.PhotoVsImageService;
import com.service.service.SachService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author longt
 */
@RestController
@RequestMapping("/api")
public class SachRestController {
    @Autowired
    private SachService sachService;
    
    @Autowired
    private CartService serviceCart;
    
    @Autowired
    private InfoService serviceIF;
    
    @Autowired
    private PhotoVsImageService servicePTIM;
    
    @GetMapping("/books")
    public List<Sach> getListSach(){
        List<Sach> list = sachService.getListSach();
        return list;
    }
    
    @GetMapping("/books/search/{q}")
    public List<Sach> getListSachSearch(@PathVariable String q){
        List<Sach> list = sachService.getListSach(q);
        return list;
    }
    
    @GetMapping("/books/{id}")
    public Sach getSach(@PathVariable int id){
        Sach sach = sachService.getSach(id);
        if(sach == null){
            throw new CustomNotFoundException("Sach khong tim thay (maSach:"+id+")");
        }
        return sach;
    }
    
    @PostMapping("/books")
    public Sach addSach(@RequestBody Sach s){
        s.setMaSach(0);
        return sachService.saveSach(s);
    }
    
    @PutMapping("/books")
    public Sach updateSach(@RequestBody Sach s){
        sachService.saveSach(s);
        Set<String> set = s.getThongTinThem();
        serviceIF.deleteSach(s.getMaSach());
        int maSach = s.getMaSach();
        for (String string : set) {
            serviceIF.saveInfo(maSach,string);
        }
        return s;
    }
    
    @DeleteMapping("/books/{id}")
    public String deleteSach(@PathVariable int id){
        Sach s = sachService.getSach(id);
        if(s == null){
            throw new CustomNotFoundException("Sach khong tim thay (maSach:"+id+")");
        }        
        serviceIF.deleteSach(id);
        serviceCart.deleteGioHang(s.getMaSach());
        servicePTIM.deleteImageByIdBook(id);
        sachService.deleteSach(s);
        return "Sach xoa thanh cong (maSac:"+id+")";
    }
}
