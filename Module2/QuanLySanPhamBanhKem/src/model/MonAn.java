package model;

import java.io.Serializable;

/**
 * Lớp MonAn đại diện cho một món ăn trong hệ thống.
 * Chứa các thuộc tính cơ bản như id, mã, tên, loại, giá, số lượng, mô tả, trạng thái xoá.
 * Được sử dụng trong quản lý sản phẩm và đơn hàng.
 */
public class MonAn implements Serializable {
    private String id;
    private String ma;
    private String ten;
    private String loai;
    private double gia;
    private int soLuong;
    private String moTa;
    private boolean daXoa;

    public MonAn(String id, String ma, String ten, String loai, double gia, int soLuong, String moTa) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Object getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Object getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Mã: %s | Tên: %s | Loại: %s | Giá: %.2f | SL: %d | Mô tả: %s",
                (Object) id, ma, ten, loai, gia, soLuong, moTa);
    }
}
