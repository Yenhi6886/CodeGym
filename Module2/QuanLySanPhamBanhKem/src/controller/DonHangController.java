package controller;

import model.*;
import java.io.*;
import java.util.*;

/**
 * Lớp DonHangController quản lý danh sách các đơn hàng.
 * Đảm nhiệm các chức năng thêm đơn hàng, đọc/ghi file cho đơn hàng.
 * Được sử dụng bởi lớp MainView để thao tác dữ liệu đơn hàng.
 */
public class DonHangController {
    private List<DonHang> danhSachDon = new ArrayList<>();

    public void themDon(DonHang dh) {
        danhSachDon.add(dh);
    }

    public List<DonHang> getDanhSachDon() {
        return danhSachDon;
    }

    public void docFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            danhSachDon = (List<DonHang>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Không thể đọc đơn hàng: " + e.getMessage());
        }
    }

    public void ghiFile(String path) {
        // Ghi file dạng text, mỗi đơn hàng 1 block, phân tách bằng dấu phẩy
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            for (DonHang dh : danhSachDon) {
                bw.write(String.format("%s,%s,%s,%s,%.2f,%s,%s",
                        dh.ma, dh.tenNguoiMua, dh.sdt, dh.diaChi, dh.tongTien, dh.ngayDat, dh.trangThai));
                bw.newLine();
                for (ItemDonHang item : dh.danhSachMon) {
                    bw.write("  - " + item.toString());
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Không thể ghi đơn hàng: " + e.getMessage());
        }
    }

    public void ghiFileText(String path) {
        ghiFile(path);
    }
}