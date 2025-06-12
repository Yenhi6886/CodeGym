package view;

import controller.*;
import model.*;

import java.util.*;
import java.util.regex.Pattern;

//  Đây là giao diệchịu trách nhiệm giao tiếp với người dùng, gọi hàm xử lý nghiệp vụ ở controller.
public class MainView {
    private static Scanner sc = new Scanner(System.in);
    private final String MONAN_FILE = "monan.txt";
    private final String DONHANG_FILE = "donhang.txt";
    private MonAnController monAnCtrl = new MonAnController();
    private DonHangController donHangCtrl = new DonHangController();

    public void start() {
        monAnCtrl.docFile(MONAN_FILE);
        donHangCtrl.docFile(DONHANG_FILE);

        int choice = 0;
        do {
            System.out.println("\n===== Cake App Menu =====");
            System.out.println("1. Thêm món ăn");
            System.out.println("2. Sửa món ăn");
            System.out.println("3. Xoá món ăn");
            System.out.println("4. Khôi phục món ăn đã xoá");
            System.out.println("5. Tìm món ăn");
            System.out.println("6. Hiển thị tất cả món ăn");
            System.out.println("7. Lên đơn hàng");
            System.out.println("8. Ghi dữ liệu ra file text");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");

            String choiceStr = sc.nextLine();
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    themMonAn();
                    break;
                case 2:
                    suaMonAn();
                    break;
                case 3:
                    xoaMonAn();
                    break;
                case 4:
                    khoiPhucMonAn();
                    break;
                case 5:
                    timMonAn();
                    break;
                case 6:
                    hienThiTatCa();
                    break;
                case 7:
                    taoDonHang();
                    break;
                case 8:
                    monAnCtrl.ghiFileText(MONAN_FILE);
                    donHangCtrl.ghiFileText(DONHANG_FILE);
                    System.out.println("Dữ liệu đã được ghi vào file text.");
                    break;
                case 9:
                    System.out.println("Kết thúc chương trình. Cảm ơn bạn!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        } while (choice != 9);
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

        MonAn mon = new MonAn(id,ma, ten, loai, gia, sl, moTa);
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
                gia = monCu.getGia();
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
                sl = monCu.getSoLuong();
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