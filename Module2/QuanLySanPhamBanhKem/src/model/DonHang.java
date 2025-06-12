package model;

import java.io.Serializable;
import java.util.*;

/**
 * Lớp DonHang đại diện cho một đơn hàng của khách.
 * Chứa thông tin người mua, danh sách món, tổng tiền, ngày đặt, trạng thái.
 * Được sử dụng để lưu trữ và xử lý các đơn hàng trong hệ thống.
 */
public class DonHang implements Serializable {
    public String ma;
    public String tenNguoiMua;
    public String sdt;
    public String diaChi;
    public List<ItemDonHang> danhSachMon;
    public double tongTien;
    public Date ngayDat;
    public String trangThai;

    public DonHang(String ma, String tenNguoiMua, String sdt, String diaChi,
                   List<ItemDonHang> danhSachMon, String trangThai) {
        this.ma = ma;
        this.tenNguoiMua = tenNguoiMua;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.danhSachMon = danhSachMon;
        this.tongTien = tinhTongTien();
        this.ngayDat = new Date();
        this.trangThai = trangThai;
    }

    private double tinhTongTien() {
        double sum = 0;
        for (ItemDonHang item : danhSachMon) {
            sum += item.tinhTien();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "DonHang{" +
                "ma='" + ma + '\'' +
                ", tenNguoiMua='" + tenNguoiMua + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", tongTien=" + tongTien +
                ", ngayDat=" + ngayDat +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}