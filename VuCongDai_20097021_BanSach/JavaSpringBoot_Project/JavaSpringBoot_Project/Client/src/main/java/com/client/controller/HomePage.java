/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author longt
 */
@Controller
public class HomePage {

    @Autowired
    private KhachHangService service;

    @GetMapping({"/", "/home"})
    public String startHomePage(Model model) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();        
        return "index";
    }

    @GetMapping("/about")
    public String startAbout(Model model) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        return "about";
    }

    @GetMapping("/contact")
    public String startContact(Model model) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        return "contact";
    }

    @GetMapping("/loginPage")
    public String showMyLoginPage() {
        return "login";
    }
    
    @GetMapping("/accessDeniedPage")
    public String showAccessDeniedPage() {
        return "accessDeniedPage";
    }
}
