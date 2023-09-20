package com.example.mob2041_soucre_code_ph31267.model;

import java.io.Serializable;

public class ThanhVien implements Serializable {
    private int maThanhVien;
    private String tenThanhVien, hoThanhVien;
    private int namSinh;

    public ThanhVien() {
    }

    public ThanhVien(int maThanhVien, String tenThanhVien, String hoThanhVien, int namSinh) {
        this.maThanhVien = maThanhVien;
        this.tenThanhVien = tenThanhVien;
        this.hoThanhVien = hoThanhVien;
        this.namSinh = namSinh;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public ThanhVien setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
        return this;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public ThanhVien setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
        return this;
    }

    public String getHoThanhVien() {
        return hoThanhVien;
    }

    public ThanhVien setHoThanhVien(String hoThanhVien) {
        this.hoThanhVien = hoThanhVien;
        return this;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public ThanhVien setNamSinh(int namSinh) {
        this.namSinh = namSinh;
        return this;
    }
}
