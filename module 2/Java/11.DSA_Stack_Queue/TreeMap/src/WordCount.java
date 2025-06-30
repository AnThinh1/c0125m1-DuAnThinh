import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào chuỗi cần kiểm tra:");
        String input = sc.nextLine();

        // Chuyển toàn bộ về chữ thường và tách từ
        String[] words = input.toLowerCase().split("\\s+");

        // Khởi tạo TreeMap
        TreeMap<String, Integer> wordMap = new TreeMap<>();

        // Duyệt từng từ
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        // Hiển thị kết quả
        System.out.println("Số lượng từ trong chuỗi:");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
