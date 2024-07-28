/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.entity.TaiKhoan;
import com.service.exception.CustomNotFoundException;
import com.service.service.TaiKhoanService;
import java.util.List;
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
public class TaiKhoanRestController {

    @Autowired
    private TaiKhoanService service;

    @GetMapping("/accounts")
    public List<TaiKhoan> getListTaiKhoan() {
        List<TaiKhoan> list = service.getListTaiKhoan();
        return list;
    }

    @GetMapping("/accounts/{id}")
    public TaiKhoan getTaiKhoan(@PathVariable int id) {
        TaiKhoan taiKhoan = service.getTaiKhoan(id);
        if (taiKhoan == null) {
            throw new CustomNotFoundException("Tai khoan khong tim thay (ID:" + id + ")");
        }
        return taiKhoan;
    }

    @GetMapping("/accounts/check/{username}")
    public boolean checkTaiKhoan(@PathVariable String username) {
        return service.checkTaiKhoan(username);
    }

    @PostMapping("/accounts")
    public TaiKhoan addTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        taiKhoan.setIdTaiKhoan(0);
        taiKhoan = service.saveTaiKhoan(taiKhoan);
        return taiKhoan;
    }
    
    @PutMapping("/accounts")
    public TaiKhoan updateTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        service.saveTaiKhoan(taiKhoan);
        return taiKhoan;
    }

    @DeleteMapping("/accounts/{id}")
    public String deleteTaiKhoan(@PathVariable int id) {
        TaiKhoan taiKhoan = service.getTaiKhoan(id);
        if (taiKhoan == null) {
            throw new CustomNotFoundException("Tai khoan khong tim thay (ID:" + id + ")");
        }
        service.deleteTaiKhoan(taiKhoan);
        return "Tai khoan xoa thanh cong (ID:" + id + ")";
    }

}
