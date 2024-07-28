/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.entity.GioHang;
import com.service.exception.CustomNotFoundException;
import com.service.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class GioHangRestController {

    @Autowired
    private CartService service;

    @GetMapping("/carts")
    public List<GioHang> getListGioHang() {
        return service.getListGioHang();
    }

    @GetMapping("/carts/{id}")
    public List<GioHang> getGioHang(@PathVariable int id) {
        List<GioHang> gh = service.getGioHang(id);
        if (gh == null) {
            throw new CustomNotFoundException("Gio hang khong tim thay (ID:" + id + ")");
        }
        return gh;
    }
    
    @GetMapping("/carts/{id}/{maSach}")
    public GioHang getGioHang(@PathVariable(name = "id") int id, @PathVariable(name = "maSach") int maSach){
        return service.getGioHang(id,maSach);
    }
    
    @PutMapping("/carts")
    public GioHang addGioHang(@RequestBody GioHang gh){
        try {
            service.saveGioHang(gh);
        } catch (Exception e) {
            throw new CustomNotFoundException("San pham ("+gh.getMaSach().getMaSach()+") them vao khach hang ("+gh.getMaKhachHang().getMaKhachHang()+") khong thanh cong");
        }        
        return gh;
    }
    
    @DeleteMapping("/carts/{id}/{maSach}")
    public String deleteGioHang(@PathVariable(name = "id") int id, @PathVariable(name = "maSach") int maSach){
        GioHang gh = service.getGioHang(id,maSach);
        if (gh == null) {
            throw new CustomNotFoundException("Gio hang khong tim thay (ID:" + id + ")");
        }
        service.deleteGioHang(gh);
        return "Gio hang xoa thanh cong (ID:"+id+")";
    }
}
