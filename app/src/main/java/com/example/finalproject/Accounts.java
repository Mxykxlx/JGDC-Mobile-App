package com.example.finalproject;

import android.graphics.Bitmap;

public class Accounts {
    private Bitmap img;
    private String ttl, rmrks, bday, gndr, hbbs;


    public Accounts(Bitmap img, String ttl, String rmrks, String bday, String gndr, String hbbs) {
        this.setImg(img);
        this.setTtl(ttl);
        this.setRmrks(rmrks);
        this.setBday(bday);
        this.setGndr(gndr);
        this.setHbbs(hbbs);
    }

    public Bitmap getImg() {
        return img;
    }
    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getRmrks() {
        return rmrks;
    }
    public void setRmrks(String rmrks) {
        this.rmrks = rmrks;
    }

    public String getBday() { return bday; }
    public void setBday(String bday) { this.bday = bday; }

    public String getGndr() { return gndr; }
    public void setGndr(String gndr) { this.gndr = gndr; }

    public String getHbbs() { return hbbs; }
    public void setHbbs(String hbbs) { this.hbbs = hbbs; }
}
