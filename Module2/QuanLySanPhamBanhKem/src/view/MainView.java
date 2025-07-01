package view;

import controller.*;
import model.*;

import java.util.*;
import java.util.regex.Pattern;

//  Đây là giao diệchịu trách nhiệm giao tiếp với người dùng, gọi hàm xử lý nghiệp vụ ở controller.
public class MainView {
    private static final Scanner sc = new Scanner(System.in);
    private final String MONAN_FILE = "monan.csv";
    private final String DONHANG_FILE = "donhang.csv";
    private MonAnController monAnCtrl = new MonAnController();
    private DonHangController donHangCtrl = new DonHangController();


    public void start() {
        monAnCtrl.docFile(MONAN_FILE);
        donHangCtrl.docFile(DONHANG_FILE, monAnCtrl);
        int choice = 0;
        do {
            menu();
            String choiceStr = sc.nextLine();
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }
            switch (choice) {
                case 1 -> themMonAn();
                case 2 -> suaMonAn();
                case 3 -> xoaMonAn();
                case 4 -> khoiPhucMonAn();
                case 5 -> timMonAn();
                case 6 -> hienThiTatCa();
                case 7 -> taoDonHang();
                case 8 -> {
                    monAnCtrl.ghiFileText(MONAN_FILE);
                    donHangCtrl.ghiFileText(DONHANG_FILE);
                    System.out.println("Đã lưu CSV.");
                }
                case 9 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn sai.");
            }
        } while (choice != 9);
    }

    private void menu() {
        System.out.println("\n1.Thêm 2.Sửa 3.Xoá 4.Khôi phục 5.Tìm 6.Xem tất cả 7.Đặt hàng 8.Lưu 9.Thoát");
        System.out.print("Chọn: ");
    }

    private void themMonAn() {
        String id;

        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (monAnCtrl.timTheoId(id) != null) {
                System.out.println("ID đã tồn tại, vui lòng nhập ID khác!");
            } else {
                break;
            }
        }

        String ma;
        Pattern pattern = Pattern.compile("^[a-zA-Z]+-\\d{4}$");
        while (true) {
            System.out.print("Mã món ăn : ");
            ma = sc.nextLine();
            if (!pattern.matcher(ma).matches()) {
                System.out.println("Mã món ăn không đúng định dạng! Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.print("Tên: ");
        String ten = sc.nextLine();
        System.out.print("Loại: ");
        String loai = sc.nextLine();

        double gia;
        while (true) {
            System.out.print("Giá: ");
            String giaStr = sc.nextLine();
            try {
                gia = Double.parseDouble(giaStr);
                if (gia < 0) {
                    System.out.println("Giá phải lớn hơn hoặc bằng 0! Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số! Vui lòng nhập lại.");
            }
        }

        int sl;
        while (true) {
            System.out.print("Số lượng: ");
            String slStr = sc.nextLine();
            try {
                sl = Integer.parseInt(slStr);
                if (sl < 0) {
                    System.out.println("Số lượng phải lớn hơn hoặc bằng 0! Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là số nguyên! Vui lòng nhập lại.");
            }
        }

        System.out.print("Mô tả: ");
        String moTa = sc.nextLine();

        MonAn mon = new MonAn(id, ma, ten, loai, gia, sl, moTa);
        monAnCtrl.themMonAn(mon);
        System.out.println("Đã thêm món ăn!");
    }

    private void suaMonAn() {
        System.out.print("Nhập ID món cần sửa: ");
        String id = sc.nextLine();
        MonAn monCu = monAnCtrl.timTheoId(id);
        if (monCu == null || monCu.isDaXoa()) {
            System.out.println("Không tìm thấy món với ID trên hoặc món đã bị xoá.");
            return;
        }

        // Nhập lại thông tin mới, cho phép bỏ qua trường không muốn sửa (ấn Enter để giữ nguyên)
        System.out.println("Nhấn Enter để giữ nguyên giá trị cũ.");
        System.out.printf("Mã món ăn (%s): ", monCu.getMa());
        String ma = sc.nextLine();
        if (ma.trim().isEmpty()) ma = monCu.getMa();
        else {
            Pattern pattern = Pattern.compile("^[a-zA-Z]+-\\d{4}$");
            while (!pattern.matcher(ma).matches()) {
                System.out.println("Mã món ăn không đúng định dạng! Vui lòng nhập lại.");
                System.out.printf("Mã món ăn (%s): ", monCu.getMa());
                ma = sc.nextLine();
                if (ma.trim().isEmpty()) {
                    ma = monCu.getMa();
                    break;
                }
            }
        }

        System.out.printf("Tên (%s): ", monCu.getTen());
        String ten = sc.nextLine();
        if (ten.trim().isEmpty()) ten = monCu.getTen();

        System.out.printf("Loại (%s): ", monCu.getLoai());
        String loai = sc.nextLine();
        if (loai.trim().isEmpty()) loai = monCu.getLoai();

        double gia;
        while (true) {
            System.out.printf("Giá (%.2f): ", monCu.getGia());
            String giaStr = sc.nextLine();
            if (giaStr.trim().isEmpty()) {
                gia = (double) monCu.getGia();
                break;
            }
            try {
                gia = Double.parseDouble(giaStr);
                if (gia < 0) {
                    System.out.println("Giá phải lớn hơn hoặc bằng 0! Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số! Vui lòng nhập lại.");
            }
        }

        int sl;
        while (true) {
            System.out.printf("Số lượng (%d): ", monCu.getSoLuong());
            String slStr = sc.nextLine();
            if (slStr.trim().isEmpty()) {
                sl = (int) monCu.getSoLuong();
                break;
            }
            try {
                sl = Integer.parseInt(slStr);
                if (sl < 0) {
                    System.out.println("Số lượng phải lớn hơn hoặc bằng 0! Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là số nguyên! Vui lòng nhập lại.");
            }
        }

        System.out.printf("Mô tả (%s): ", monCu.getMoTa());
        String moTa = sc.nextLine();
        if (moTa.trim().isEmpty()) moTa = monCu.getMoTa();

        MonAn monMoi = new MonAn(id, ma, ten, loai, gia, sl, moTa);
        monAnCtrl.suaMonAn(id, monMoi);
        System.out.println("Đã sửa món ăn!");
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
        System.out.print("Nhập ID hoặc tên: ");
        String key = sc.nextLine();
        MonAn byId = monAnCtrl.timTheoId(key);
        if (byId != null) System.out.println(byId);
        else {
            List<MonAn> list = monAnCtrl.timTheoTen(key);
            if (list.isEmpty()) System.out.println("Không tìm thấy.");
            else list.forEach(System.out::println);
        }
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
            if (mon == null || mon.isDaXoa()) {
                System.out.println("Không tìm thấy món");
                continue;
            }

            int sl;
            while (true) {
                System.out.print("Số lượng: ");
                String slStr = sc.nextLine();
                try {
                    sl = Integer.parseInt(slStr);
                    if (sl <= 0) {
                        System.out.println("Số lượng phải lớn hơn 0! Vui lòng nhập lại.");
                        continue;
                    }
                    if (sl > ((Integer) mon.getSoLuong())) {
                        System.out.println("Không đủ hàng. Số lượng còn lại: " + mon.getSoLuong());
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Số lượng phải là số nguyên! Vui lòng nhập lại.");
                }
            }
            mon.setSoLuong(((Integer) mon.getSoLuong()) - sl);
            items.add(new ItemDonHang(mon, sl));
        }

        if (items.isEmpty()) {
            System.out.println("Không có món nào được chọn.");
            return;
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