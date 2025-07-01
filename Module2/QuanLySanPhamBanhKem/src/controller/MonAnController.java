package controller;

import model.MonAn;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Lớp MonAnController quản lý danh sách, đảm nhiệm các chức năng thêm, sửa, xoá, khôi phục,
 * tìm kiếm theo ID hoặc tên, đọc/ghi file CSV cho món ăn.
 */
public class MonAnController {
    private List<MonAn> danhSachMonAn = new ArrayList<>();

    public void themMonAn(MonAn ma) {
        danhSachMonAn.add(ma);
    }

    public boolean suaMonAn(String id, MonAn monAnMoi) {
        for (int i = 0; i < danhSachMonAn.size(); i++) {
            MonAn m = danhSachMonAn.get(i);
            if (m.getId().equalsIgnoreCase(id)) {
                boolean daXoa = m.isDaXoa();
                monAnMoi.setDaXoa(daXoa);
                danhSachMonAn.set(i, monAnMoi);
                return true;
            }
        }
        return false;
    }

    public boolean xoaMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null) return false;
        monAn.setDaXoa(true);
        return true;
    }

    public MonAn timTheoId(String id) {
        return danhSachMonAn.stream()
                .filter(m -> m.getId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    /**
     * Tìm món ăn theo tên chứa chuỗi key (ignore case)
     */
    public List<MonAn> timTheoTen(String key) {
        String k = key.toLowerCase();
        List<MonAn> result = new ArrayList<>();
        for (MonAn m : danhSachMonAn) {
            if (!m.isDaXoa() && m.getTen().toLowerCase().contains(k)) {
                result.add(m);
            }
        }
        return result;
    }

    public boolean khoiPhucMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null || !monAn.isDaXoa()) return false;
        monAn.setDaXoa(false);
        return true;
    }

    public List<MonAn> getDanhSach() {
        return danhSachMonAn;
    }

    /**
     * Đọc file CSV: id,ma,ten,loai,gia,soLuong,moTa,daXoa
     */
    public void docFile(String path) {
        danhSachMonAn.clear();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] f = line.split(",", -1);
                if (f.length < 8) continue;
                // Đúng thứ tự: id,ma,ten,loai,gia,soLuong,moTa,daXoa
                MonAn m = new MonAn(f[0], f[1], f[2], f[3],
                        Double.parseDouble(f[4]), Integer.parseInt(f[5]), f[6]);
                m.setDaXoa(Boolean.parseBoolean(f[7]));
                danhSachMonAn.add(m);
            }
        } catch (Exception e) {
            System.out.println("Không thể đọc file CSV: " + e.getMessage());
        }
    }

    /**
     * Ghi file CSV: id,ma,ten,loai,gia,soLuong,moTa,daXoa
     */
    public void ghiFileText(String path) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            for (MonAn m : danhSachMonAn) {
                bw.write(String.join(",",
                        m.getId(), m.getMa(), m.getTen(), m.getLoai(),
                        String.valueOf(m.getGia()), String.valueOf(m.getSoLuong()),
                        m.getMoTa().replace(",", " "), String.valueOf(m.isDaXoa())
                ));
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Không thể ghi file CSV: " + e.getMessage());
        }
    }
}