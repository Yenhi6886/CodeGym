package model;

import java.io.Serializable;

/**
 * Lớp ItemDonHang đại diện cho một món ăn cụ thể trong đơn hàng.
 * Lưu thông tin món ăn và số lượng đặt mua.
 * Được sử dụng trong lớp DonHang để quản lý chi tiết từng món trong đơn.
 */
public class ItemDonHang implements Serializable {
    private MonAn monAn;
    private int soLuong;

    public ItemDonHang(MonAn monAn, int soLuong) {
        this.monAn = monAn;
        this.soLuong = soLuong;
    }

    public double tinhTien() {
        return ((Number) monAn.getGia()).doubleValue() * soLuong;
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