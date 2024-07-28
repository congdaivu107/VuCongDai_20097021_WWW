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
public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String string) {
        super(string);
    }

    public CustomNotFoundException() {
        super();
    }
}
