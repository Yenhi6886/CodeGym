package model;

import java.io.Serializable;

public class MonAn implements Serializable {
    private String id;
    private String ten;
    private String loai;
    private double gia;
    private int soLuong;
    private String moTa;
    private boolean daXoa;

    public MonAn(String id, String ten, String loai, double gia, int soLuong, String moTa) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public String getId() { return id; }
    public String getTen() { return ten; }
    public String getLoai() { return loai; }
    public double getGia() { return gia; }
    public int getSoLuong() { return soLuong; }
    public String getMoTa() { return moTa; }
    public boolean isDaXoa() { return daXoa; }
    public void setDaXoa(boolean daXoa) { this.daXoa = daXoa; }

    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | Loại: %s | Giá: %.2f | SL: %d | Mô tả: %s",
                id, ten, loai, gia, soLuong, moTa);
    }
}