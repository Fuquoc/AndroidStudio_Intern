package com.example.screen1_activity;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public String MaSinhVien;
    public String HoTen;
    public int SoDienThoai;

    SinhVien(String maSinhVien,String hoTen,int soDienThoai){
        MaSinhVien = maSinhVien;
        HoTen = hoTen;
        SoDienThoai = soDienThoai;
    }
}
