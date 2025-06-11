package view;

import controller.*;
import model.*;

import java.util.*;

public class MainView {
    private static Scanner sc = new Scanner(System.in);
    private final String MONAN_FILE = "monan.txt";
    private final String DONHANG_FILE = "donhang.txt";
    private MonAnController monAnCtrl = new MonAnController();
    private DonHangController donHangCtrl = new DonHangController();

    public void start() {
        monAnCtrl.docFile(MONAN_FILE);
        donHangCtrl.docFile(DONHANG_FILE);

        int choice;
        do {
            System.out.println("\n===== Cake App Menu =====");
            System.out.println("1. Thêm món ăn");
            System.out.println("2. Xoá món ăn");
            System.out.println("3. Khôi phục món ăn đã xoá");
            System.out.println("4. Tìm món ăn");
            System.out.println("5. Hiển thị tất cả món ăn");
            System.out.println("6. Lên đơn hàng");
            System.out.println("7. Ghi dữ liệu ra file text");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themMonAn();
                    break;
                case 2:
                    xoaMonAn();
                    break;
                case 3:
                    khoiPhucMonAn();
                    break;
                case 4:
                    timMonAn();
                    break;
                case 5:
                    hienThiTatCa();
                    break;
                case 6:
                    taoDonHang();
                    break;
                case 7:
                    monAnCtrl.ghiFileText(MONAN_FILE);
                    donHangCtrl.ghiFileText(DONHANG_FILE);
                    System.out.println("Dữ liệu đã được ghi vào file text.");
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình. Cảm ơn bạn!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        } while (choice != 8);
    }

    private void themMonAn() {
        String id;
        // Lặp cho đến khi nhập được ID chưa tồn tại
        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (monAnCtrl.timTheoId(id) != null) {
                System.out.println("ID đã tồn tại, vui lòng nhập ID khác!");
            } else {
                break;
            }
        }
        System.out.print("Tên: ");
        String ten = sc.nextLine();
        System.out.print("Loại: ");
        String loai = sc.nextLine();

        // Kiểm tra nhập giá đúng định dạng số
        double gia;
        while (true) {
            System.out.print("Giá: ");
            String giaStr = sc.nextLine();
            try {
                gia = Double.parseDouble(giaStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số! Vui lòng nhập lại.");
            }
        }

        // Kiểm tra nhập số lượng đúng định dạng số nguyên
        int sl;
        while (true) {
            System.out.print("Số lượng: ");
            String slStr = sc.nextLine();
            try {
                sl = Integer.parseInt(slStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là số nguyên! Vui lòng nhập lại.");
            }
        }

        System.out.print("Mô tả: ");
        String moTa = sc.nextLine();

        MonAn mon = new MonAn(id, ten, loai, gia, sl, moTa);
        monAnCtrl.themMonAn(mon);
        System.out.println("Đã thêm món ăn!");
    }

    private void xoaMonAn() {
        System.out.print("Nhập ID món cần xoá: ");
        String id = sc.nextLine();
        if (monAnCtrl.xoaMonAn(id)) {
            System.out.println("Xoá thành công");
        } else {
            System.out.println("Không tìm thấy món với ID trên");
        }
    }

    // Thêm chức năng khôi phục món ăn đã xoá
    private void khoiPhucMonAn() {
        System.out.print("Nhập ID món cần khôi phục: ");
        String id = sc.nextLine();
        if (monAnCtrl.khoiPhucMonAn(id)) {
            System.out.println("Khôi phục thành công");
        } else {
            System.out.println("Không tìm thấy món đã xoá hoặc món chưa bị xoá");
        }
    }

    private void timMonAn() {
        System.out.print("Nhập ID món cần tìm: ");
        String id = sc.nextLine();
        MonAn mon = monAnCtrl.timTheoId(id);
        if (mon != null) System.out.println(mon);
        else System.out.println("Không tìm thấy món");
    }

    private void hienThiTatCa() {
        for (MonAn mon : monAnCtrl.getDanhSach()) {
            if (mon.isDaXoa()) continue; // Bỏ qua món đã xoá
            System.out.println(mon);
        }
    }

    private void taoDonHang() {
        List<ItemDonHang> items = new ArrayList<>();
        hienThiTatCa();

        while (true) {
            System.out.print("Nhập ID món muốn mua (hoặc 'x' để kết thúc): ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("x")) break;
            MonAn mon = monAnCtrl.timTheoId(id);
            if (mon == null) {
                System.out.println("Không tìm thấy món");
                continue;
            }
            // Kiểm tra nhập số lượng đúng định dạng số nguyên
            int sl;
            while (true) {
                System.out.print("Số lượng: ");
                String slStr = sc.nextLine();
                try {
                    sl = Integer.parseInt(slStr);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Số lượng phải là số nguyên! Vui lòng nhập lại.");
                }
            }
            if (sl > mon.getSoLuong()) {
                System.out.println("Không đủ hàng");
                continue;
            }
            mon.setSoLuong(mon.getSoLuong() - sl);
            items.add(new ItemDonHang(mon, sl));
        }

        System.out.print("Tên người mua: ");
        String ten = sc.nextLine();
        System.out.print("SĐT: ");
        String sdt = sc.nextLine();
        System.out.print("Địa chỉ: ");
        String dc = sc.nextLine();
        String ma = "DH" + System.currentTimeMillis();

        DonHang dh = new DonHang(ma, ten, sdt, dc, items, "Đã xác nhận");
        donHangCtrl.themDon(dh);
        System.out.println("Đơn hàng đã được tạo:");
        System.out.println(dh);
    }
}