package com.example.nurul.uts;

public class MenuModel {

    private int id;
    private String namalaptop;
    private String tipe;
    private String harga;
    private String berat;
    private String ram;


    public MenuModel(int id, String namalaptop, String tipe, String harga, String berat, String ram) {
        this.id = id;
        this.namalaptop = namalaptop;
        this.tipe = tipe;
        this.berat = berat;
        this.ram = ram;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNamalaptop() {
        return namalaptop;
    }

    public String getTipe() {
        return tipe;
    }

    public String getBerat() {
        return harga;
    }

    public String getRam() {
        return harga;
    }

    public String getHarga() {
        return harga;
    }

}
