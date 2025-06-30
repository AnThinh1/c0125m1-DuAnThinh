import java.util.Stack;

public class ReverseArrayWithStack {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Stack<Integer> stack = new Stack<>();

        // Đưa phần tử vào Stack
        for (int num : arr) {
            stack.push(num);
        }

        // Lấy ngược phần tử từ Stack gán lại cho mảng
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        // In mảng sau khi đảo ngược
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
