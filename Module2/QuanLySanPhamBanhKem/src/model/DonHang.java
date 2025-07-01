package model;

import java.io.Serializable;
import java.time.LocalDate;
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
    public LocalDate ngayDat;
    public String trangThai;

    // Constructor mặc định cho tạo mới (ngày hiện tại)
    public DonHang(String ma, String tenNguoiMua, String sdt, String diaChi,
                   List<ItemDonHang> danhSachMon, String trangThai) {
        this.ma = ma;
        this.tenNguoiMua = tenNguoiMua;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.danhSachMon = danhSachMon;
        this.tongTien = tinhTongTien();
        this.ngayDat = LocalDate.now();
        this.trangThai = trangThai;
    }

    // Constructor cho đọc file (ngày đặt truyền vào)
    public DonHang(String ma, String tenNguoiMua, String sdt, String diaChi,
                   List<ItemDonHang> danhSachMon, String trangThai, LocalDate ngayDat) {
        this.ma = ma;
        this.tenNguoiMua = tenNguoiMua;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.danhSachMon = danhSachMon;
        this.tongTien = tinhTongTien();
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
    }

    private double tinhTongTien() {
        double sum = 0;
        for (ItemDonHang item : danhSachMon) {
            sum += item.tinhTien();
        }
        return sum;
    }

    // Getter cho controller sử dụng
    public String getMa() { return ma; }
    public String getTenNguoiMua() { return tenNguoiMua; }
    public String getSdt() { return sdt; }
    public String getDiaChi() { return diaChi; }
    public List<ItemDonHang> getDanhSachMon() { return danhSachMon; }
    public double getTongTien() { return tongTien; }
    public LocalDate getNgayDat() { return ngayDat; }
    public String getTrangThai() { return trangThai; }

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
