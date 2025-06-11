package model;

import java.io.Serializable;

public class ItemDonHang implements Serializable {
    private MonAn monAn;
    private int soLuong;

    public ItemDonHang(MonAn monAn, int soLuong) {
        this.monAn = monAn;
        this.soLuong = soLuong;
    }

    public double tinhTien() {
        return monAn.getGia() * soLuong;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String toString() {
        return monAn.getTen() + " x " + soLuong + " = " + tinhTien();
    }
}