/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author longt
 */
public class ItemBook {
    private int maSach;
    private String name, auth, decriber, infor;
    private double money, rate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate datePub;

    public ItemBook() {
    }

    public ItemBook(int maSach, String name, String auth, String decriber, String infor, double money, double rate, LocalDate datePub) {
        this.maSach = maSach;
        this.name = name;
        this.auth = auth;
        this.decriber = decriber;
        this.infor = infor;
        this.money = money;
        this.rate = rate;
        this.datePub = datePub;
    }
    
    

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getDecriber() {
        return decriber;
    }

    public void setDecriber(String decriber) {
        this.decriber = decriber;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDatePub() {
        return datePub;
    }

    public void setDatePub(LocalDate datePub) {
        this.datePub = datePub;
    }

    @Override
    public String toString() {
        return "ItemBook{" + "maSach=" + maSach + ", name=" + name + ", auth=" + auth + ", decriber=" + decriber + ", infor=" + infor + ", money=" + money + ", rate=" + rate + ", datePub=" + datePub + '}';
    }
    
    
}
