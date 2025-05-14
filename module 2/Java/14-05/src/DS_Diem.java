import java.util.Scanner;

public class DS_Diem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soLuong = nhapSoLuongSinhVien(sc);

        if (soLuong <= 0 || soLuong > 100) {
            System.out.println("Số lượng không hợp lệ. Chương trình kết thúc!");
            return; // Kết thúc chương trình nếu số lượng không hợp lệ
        }

        double[] diem = nhapDiemSinhVien(sc, soLuong);

        hienThiDanhSachDiem(diem, soLuong);

        double diemTrungBinh = tinhDiemTrungBinh(diem, soLuong);
        System.out.println("\nĐiểm trung bình: " + diemTrungBinh);

        kiemTraDiemTrongDanhSach(sc, diem, soLuong);

        xepLoaiSinhVien(diem, soLuong);
    }

    // Phương thức nhập số lượng sinh viên
    public static int nhapSoLuongSinhVien(Scanner sc) {
        System.out.print("Nhập số lượng sinh viên (tối đa 100): ");
        return sc.nextInt();
    }

    // Phương thức nhập điểm cho sinh viên
    public static double[] nhapDiemSinhVien(Scanner sc, int soLuong) {
        double[] diem = new double[soLuong];
        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
            diem[i] = sc.nextDouble();
        }
        return diem;
    }

    // Phương thức hiển thị danh sách điểm sinh viên
    public static void hienThiDanhSachDiem(double[] diem, int soLuong) {
        System.out.println("\nDanh sách điểm sinh viên:");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Sinh viên " + (i + 1) + ": " + diem[i]);
        }
    }

    // Phương thức tính điểm trung bình
    public static double tinhDiemTrungBinh(double[] diem, int soLuong) {
        double tongDiem = 0;
        for (int i = 0; i < soLuong; i++) {
            tongDiem += diem[i];
        }
        return tongDiem / soLuong;
    }

    // Phương thức kiểm tra điểm cần tìm có trong danh sách không
    public static void kiemTraDiemTrongDanhSach(Scanner sc, double[] diem, int soLuong) {
        System.out.print("\nNhập điểm cần kiểm tra: ");
        double diemCanTim = sc.nextDouble();
        boolean found = false;

        for (int i = 0; i < soLuong; i++) {
            if (diem[i] == diemCanTim) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Điểm " + diemCanTim + " có trong danh sách.");
        } else {
            System.out.println("Điểm " + diemCanTim + " không có trong danh sách.");
        }
    }

    // Phương thức xếp loại sinh viên
    public static void xepLoaiSinhVien(double[] diem, int soLuong) {
        for (int i = 0; i < soLuong; i++) {
            if (diem[i] >= 8) {
                System.out.println("Sinh viên " + (i + 1) + " : GIỎI");
            } else if (diem[i] >= 6) {
                System.out.println("Sinh viên " + (i + 1) + " : KHÁ");
            } else if (diem[i] >= 5) {
                System.out.println("Sinh viên " + (i + 1) + " : TRUNG BÌNH");
            } else {
                System.out.println("Sinh viên " + (i + 1) + " : YẾU");
            }
        }
    }
}
