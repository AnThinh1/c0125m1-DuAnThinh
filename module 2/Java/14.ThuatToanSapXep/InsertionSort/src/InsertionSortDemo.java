import java.util.Scanner;

public class InsertionSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số lượng phần tử
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Nhập giá trị từng phần tử
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // Hiển thị mảng ban đầu
        System.out.print("Mảng ban đầu: ");
        displayArray(arr);

        // Thuật toán sắp xếp chèn với mô phỏng từng bước
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("\nBước " + i + ": Chèn phần tử " + key);

            // Dịch các phần tử lớn hơn key sang phải
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            // Hiển thị mảng sau mỗi bước chèn
            displayArray(arr);
        }
    }

    // Hàm hiển thị mảng
    private static void displayArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
