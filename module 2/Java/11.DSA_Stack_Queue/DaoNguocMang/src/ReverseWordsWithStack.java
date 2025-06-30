import java.util.Stack;

public class ReverseWordsWithStack {
    public static void main(String[] args) {
        String str = "Hoc Java rat don gian";

        String[] words = str.split(" ");
        Stack<String> stack = new Stack<>();

        // Đưa từng từ vào Stack
        for (String word : words) {
            stack.push(word);
        }

        // Lấy từ ra từ Stack và ghép lại
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop() + " ";
        }

        // In kết quả (có thể trim() để xóa khoảng trắng cuối)
        System.out.println(reversed.trim());
    }
}
