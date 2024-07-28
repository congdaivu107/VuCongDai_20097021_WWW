/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.BinhLuan;
import com.client.entity.KhachHang;
import com.client.entity.TaiKhoan;
import com.client.model.DangKy;
import com.client.service.BinhLuanService;
import com.client.service.KhachHangService;
import com.client.service.TaiKhoanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/register")
public class DangKyController {

    @Autowired
    private KhachHangService service;
    @Autowired
    private TaiKhoanService serviceTK;
    
    @Autowired
    private BinhLuanService serviceBL;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping({"/show", "/"})
    public String showDangKy(Model model) {
        DangKy dangKy = new DangKy();
        model.addAttribute("dangKy", dangKy);
        return "register";
    }

    @PostMapping("/addRegister")
    public String addRegister(Model model, @Valid @ModelAttribute("dangKy") DangKy dangKy, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            dangKy.setUserName("");
            model.addAttribute("dangKy", dangKy);
            model.addAttribute("registrationError", "Tài khoản người dùng hoặc mật khẩu không được để trống.");
            return "register";
        }
        if (serviceTK.checkTaiKhoan(dangKy.getUserName()) == true) {
            String text = dangKy.getUserName();
            dangKy.setUserName("");
            model.addAttribute("dangKy", dangKy);
            model.addAttribute("registrationError", "Tài khoản " + text + " đã tồn tại.");
            return "register";
        }
        String encode = passwordEncoder.encode(dangKy.getPassword());
        encode = "{bcrypt}" + encode;
        KhachHang khachHang = new KhachHang(dangKy.getFirstName(), dangKy.getLastName(), dangKy.getEmail(), dangKy.getAddress(), dangKy.getBirthDate(), dangKy.getPhone());
        khachHang.setMaKhacHang(0);
        khachHang = service.saveKhachHang(khachHang);

        TaiKhoan taiKhoan = new TaiKhoan(dangKy.getUserName(), encode, true, "ROLE_CUSTOMER", khachHang);
        taiKhoan.setIdTaiKhoan(0);

//        service.saveKhachHang(khachHang);  
        BinhLuan binhLuan = new BinhLuan(taiKhoan.getUser(), "Dang ky thanh cong 1 tai khoan CUSTOMER", null);
        serviceBL.saveBinhLuan(binhLuan);
        serviceTK.saveTaiKhoan(taiKhoan);
        return "login";
    }

}
