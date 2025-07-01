package controller;

import model.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Lớp DonHangController quản lý danh sách đơn hàng, thêm đơn, đọc/ghi file CSV.
 */
public class DonHangController {
    private List<DonHang> danhSachDon = new ArrayList<>();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ISO_DATE;

    public void themDon(DonHang dh) {
        danhSachDon.add(dh);
    }

    public List<DonHang> getDanhSachDon() {
        return danhSachDon;
    }

    /**
     * Đọc file CSV: ma,tenNguoiMua,sdt,diaChi,tongTien,ngayDat(yyyy-MM-dd),trangThai,items
     * items = id1:qty1;id2:qty2...
     */
    public void docFile(String path, MonAnController monCtrl) {
        danhSachDon.clear();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] f = line.split(",", 8);
                if (f.length < 7) continue;
                String ma = f[0], ten = f[1], sdt = f[2], dc = f[3];
                double tt = Double.parseDouble(f[4]);
                LocalDate ngay = LocalDate.parse(f[5], FMT);
                String trangThai = f[6];
                List<ItemDonHang> items = new ArrayList<>();
                if (f.length == 8 && !f[7].isEmpty()) {
                    for (String it : f[7].split(";")) {
                        String[] p = it.split(":");
                        MonAn mon = monCtrl.timTheoId(p[0]);
                        int qty = Integer.parseInt(p[1]);
                        if (mon != null) items.add(new ItemDonHang(mon, qty));
                    }
                }
                DonHang dh = new DonHang(ma, ten, sdt, dc, items, trangThai, ngay);
                danhSachDon.add(dh);
            }
        } catch (Exception e) {
            System.out.println("Không thể đọc file đơn hàng CSV: " + e.getMessage());
        }
    }

    /**
     * Ghi file CSV: ma,tenNguoiMua,sdt,diaChi,tongTien,ngayDat(yyyy-MM-dd),trangThai,items
     */
    public void ghiFileText(String path) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            for (DonHang dh : danhSachDon) {
                StringBuilder sb = new StringBuilder();
                sb.append(dh.getMa()).append(",")
                        .append(dh.getTenNguoiMua()).append(",")
                        .append(dh.getSdt()).append(",")
                        .append(dh.getDiaChi()).append(",")
                        .append(dh.getTongTien()).append(",")
                        .append(dh.getNgayDat().format(FMT)).append(",")
                        .append(dh.getTrangThai()).append(",");
                // items
                List<ItemDonHang> items = dh.getDanhSachMon();
                for (int i = 0; i < items.size(); i++) {
                    ItemDonHang it = items.get(i);
                    sb.append(it.getMonAn().getId()).append(":").append(it.getSoLuong());
                    if (i < items.size() - 1) sb.append(";");
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Không thể ghi file đơn hàng CSV: " + e.getMessage());
        }
    }
}
