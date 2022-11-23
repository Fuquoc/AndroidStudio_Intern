package com.example.myloginapp;

public class Tree {
    private String NameKH;
    private String NameTG;
    private String Dactinh;
    private String maula;
    private String congdung;
    private String duoctinh;
    private String chuy;
    private int hinhanh;


    public Tree(String nameKH, String nameTG, String dactinh, String maula, String congdung, String duoctinh, String chuy, int hinhanh) {
        NameKH = nameKH;
        NameTG = nameTG;
        Dactinh = dactinh;
        this.maula = maula;
        this.congdung = congdung;
        this.duoctinh = duoctinh;
        this.chuy = chuy;
        this.hinhanh = hinhanh;
    }

    public String getNameKH() {
        return NameKH;
    }

    public void setNameKH(String nameKH) {
        NameKH = nameKH;
    }

    public String getNameTG() {
        return NameTG;
    }

    public void setNameTG(String nameTG) {
        NameTG = nameTG;
    }

    public String getDactinh() {
        return Dactinh;
    }

    public void setDactinh(String dactinh) {
        Dactinh = dactinh;
    }

    public String getMaula() {
        return maula;
    }

    public void setMaula(String maula) {
        this.maula = maula;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getDuoctinh() {
        return duoctinh;
    }

    public void setDuoctinh(String duoctinh) {
        this.duoctinh = duoctinh;
    }

    public String getChuy() {
        return chuy;
    }

    public void setChuy(String chuy) {
        this.chuy = chuy;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
