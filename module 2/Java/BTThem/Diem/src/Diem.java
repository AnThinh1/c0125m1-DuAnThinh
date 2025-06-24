import java.util.Scanner;

public class Diem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soLuong = nhapSoLuongSinhVien(sc);
        if (soLuong > 0 && soLuong <= 100) {
            double[] diem = nhapDiemSinhVien(sc, soLuong);
            hienThiDanhSachDiem(diem, soLuong);
            double diemTrungBinh = tinhDiemTrungBinh(diem, soLuong);
            System.out.println("\nĐiểm trung bình: " + diemTrungBinh);
            kiemTraDiemTrongDanhSach(sc, diem, soLuong);
            xepLoaiSinhVien(diem, soLuong);
        } else {
            System.out.println("Số lượng không hợp lệ. Chương trình kết thúc!");
        }
    }

    public static int nhapSoLuongSinhVien(Scanner sc) {
        System.out.print("Nhập số lượng sinh viên (tối đa 100): ");
        return sc.nextInt();
    }

    public static double[] nhapDiemSinhVien(Scanner sc, int soLuong) {
        double[] diem = new double[soLuong];

        for(int i = 0; i < soLuong; ++i) {
            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
            diem[i] = sc.nextDouble();
        }

        return diem;
    }

    public static void hienThiDanhSachDiem(double[] diem, int soLuong) {
        System.out.println("\nDanh sách điểm sinh viên:");

        for(int i = 0; i < soLuong; ++i) {
            System.out.println("Sinh viên " + (i + 1) + ": " + diem[i]);
        }

    }

    public static double tinhDiemTrungBinh(double[] diem, int soLuong) {
        double tongDiem = (double)0.0F;

        for(int i = 0; i < soLuong; ++i) {
            tongDiem += diem[i];
        }

        return tongDiem / (double)soLuong;
    }

    public static void kiemTraDiemTrongDanhSach(Scanner sc, double[] diem, int soLuong) {
        System.out.print("\nNhập điểm cần kiểm tra: ");
        double diemCanTim = sc.nextDouble();
        boolean found = false;

        for(int i = 0; i < soLuong; ++i) {
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

    public static void xepLoaiSinhVien(double[] diem, int soLuong) {
        for(int i = 0; i < soLuong; ++i) {
            if (diem[i] >= (double)8.0F) {
                System.out.println("Sinh viên " + (i + 1) + " : GIỎI");
            } else if (diem[i] >= (double)6.0F) {
                System.out.println("Sinh viên " + (i + 1) + " : KHÁ");
            } else if (diem[i] >= (double)5.0F) {
                System.out.println("Sinh viên " + (i + 1) + " : TRUNG BÌNH");
            } else {
                System.out.println("Sinh viên " + (i + 1) + " : YẾU");
            }
        }

    }
}