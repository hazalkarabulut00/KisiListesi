package com.example.application.models;

public class Personel {

    private Long id;
    private String TC;
    private String Ad;
    private String Soyad;

    public Personel(Long id, String TC, String Ad, String Soyad) {
        this.id = id;
        this.TC = TC;
        this.Ad = Ad;
        this.Soyad = Soyad;
    }

    public Long getId() {
        return id;
    }

    public String getTC() {
        return TC;
    }

    public String getAd() {
        return Ad;
    }

    public String getSoyad() {
        return Soyad;
    }
}
