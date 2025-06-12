package controller;

import model.MonAn;
import java.io.*;
import java.util.*;

/**
 * Lớp MonAnController quản lý danh sách ,Đảm nhiệm các chức năng thêm, sửa, xoá, khôi phục, tìm kiếm, đọc/ghi file cho món ăn.
 * Được sử dụng bởi lớp MainView để thao tác dữ liệu món ăn.
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
                // Giữ trạng thái đã xóa
                boolean daXoa = m.isDaXoa();
                danhSachMonAn.set(i, monAnMoi);
                danhSachMonAn.get(i).setDaXoa(daXoa);
                return true;
            }
        }
        return false;
    }

    public boolean xoaMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null) {
            return false;
        } else {
            monAn.setDaXoa(true);
            return true;
        }
    }

    public MonAn timTheoId(String id) {
        for (MonAn m : danhSachMonAn) {
            if (m.getId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public boolean khoiPhucMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null) {
            return false;
        } else if (!monAn.isDaXoa()) {
            return false;
        } else {
            monAn.setDaXoa(false);
            return true;
        }
    }


    public List<MonAn> getDanhSach() {
        return danhSachMonAn;
    }

    public void docFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            danhSachMonAn = (List<MonAn>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }

    public void ghiFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            for (MonAn m : danhSachMonAn) {
                bw.write(String.format("%s,%s,%s,%s,%.2f,%d,%s",
                        m.getId(), m.getMa(), m.getTen(), m.getLoai(), m.getGia(), m.getSoLuong(), m.getMoTa()));
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Không thể ghi file: " + e.getMessage());
        }
    }

    public void ghiFileText(String path) {
        ghiFile(path);
    }
}