/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.model;

import com.client.entity.Image;
import com.client.entity.Sach;

/**
 *
 * @author longt
 */
public class ItemHomPage {
    private Sach sach;
    private Image image;

    public ItemHomPage(Sach sach, Image image) {
        this.sach = sach;
        this.image = image;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemHomPage{" + ", image=" + image + '}';
    }
    
    
}
