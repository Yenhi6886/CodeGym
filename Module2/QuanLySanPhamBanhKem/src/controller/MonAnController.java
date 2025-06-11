package controller;

import model.MonAn;
import java.io.*;
import java.util.*;

public class MonAnController {
    private List<MonAn> danhSachMonAn = new ArrayList<>();

    public void themMonAn(MonAn ma) {
        danhSachMonAn.add(ma);
    }

    public MonAn timTheoId(String id) {
        for (MonAn m : danhSachMonAn) {
            if (m.getId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public boolean xoaMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null) {
            return false; // Không tìm thấy món ăn
        } else {
            monAn.setDaXoa(true); // Đánh dấu món ăn là đã xoá
            return true; // Xoá thành công
        }
    }

    // Thêm chức năng khôi phục món ăn đã xoá
    public boolean khoiPhucMonAn(String id) {
        MonAn monAn = timTheoId(id);
        if (monAn == null) {
            return false; // Không tìm thấy món ăn
        } else if (!monAn.isDaXoa()) {
            return false; // Món ăn chưa bị xoá
        } else {
            monAn.setDaXoa(false); // Đánh dấu là chưa xoá
            return true; // Khôi phục thành công
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
        // Ghi file dạng text, mỗi món ăn 1 dòng, phân tách bằng dấu phẩy
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            for (MonAn m : danhSachMonAn) {
                bw.write(String.format("%s,%s,%s,%.2f,%d,%s",
                        m.getId(), m.getTen(), m.getLoai(), m.getGia(), m.getSoLuong(), m.getMoTa()));
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Không thể ghi file: " + e.getMessage());
        }
    }

    public void ghiFileText(String path) {
        // Giữ lại để tương thích, gọi lại ghiFile
        ghiFile(path);
    }
}