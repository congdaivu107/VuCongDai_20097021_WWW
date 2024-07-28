/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.exception;

/**
 *
 * @author longt
 */
public class CustomErrorResponse {
    private int satatus;
    private String message;
    private long time;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(int satatus, String message, long time) {
        this.satatus = satatus;
        this.message = message;
        this.time = time;
    }

    public int getSatatus() {
        return satatus;
    }

    public void setSatatus(int satatus) {
        this.satatus = satatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" + "satatus=" + satatus + ", message=" + message + ", time=" + time + '}';
    }
    
    
}
