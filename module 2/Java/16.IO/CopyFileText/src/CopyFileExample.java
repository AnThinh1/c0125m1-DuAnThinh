import java.io.*;
import java.util.Scanner;

public class CopyFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn tệp nguồn:");
        String sourcePath = scanner.nextLine();

        System.out.println("Nhập đường dẫn tệp đích:");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Kiểm tra tệp nguồn có tồn tại không
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        // Kiểm tra tệp đích đã tồn tại chưa
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại.");
            return;
        }

        int charCount = 0;

        try (
                FileReader reader = new FileReader(sourceFile);
                FileWriter writer = new FileWriter(targetFile);
        ) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                charCount++;
            }

            System.out.println("Sao chép thành công. Tổng số ký tự đã sao chép: " + charCount);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
