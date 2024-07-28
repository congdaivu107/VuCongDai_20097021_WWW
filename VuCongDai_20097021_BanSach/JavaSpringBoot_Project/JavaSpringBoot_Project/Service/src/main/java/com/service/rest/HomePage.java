/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author longt
 */
@Controller
public class HomePage {
    @GetMapping({"/","/home"})
    public String startHomePage(){
        return "index";
    }
}
