import java.util.Scanner;

public class PhanLoaiSV {
    String name;
    double grade;

    public PhanLoaiSV(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + ", Điểm: " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanLoaiSV[] students = new PhanLoaiSV[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập học sinh thứ " + (i + 1));
            System.out.print("Tên: ");
            String name = sc.nextLine();
            System.out.print("Điểm: ");
            double grade = sc.nextDouble();
            sc.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số
            students[i] = new PhanLoaiSV(name, grade); // Sửa Student -> PhanLoaiSV
        }

        System.out.println("\n--- Danh sách học sinh điểm > 8.0 ---");
        for (PhanLoaiSV s : students) {
            if (s.grade > 8.0) {
                s.displayInfo();
            }
        }

        int yeu = 0, tb = 0, khaGioi = 0;
        for (PhanLoaiSV s : students) {
            if (s.grade < 5) {
                yeu++;
            } else if (s.grade <= 7) {
                tb++;
            } else {
                khaGioi++;
            }
        }

        System.out.println("\n--- Thống kê học lực ---");
        System.out.println("Yếu: " + yeu + " sinh viên");
        System.out.println("Trung bình: " + tb + " sinh viên");
        System.out.println("Khá/Giỏi: " + khaGioi + " sinh viên");
    }
}
