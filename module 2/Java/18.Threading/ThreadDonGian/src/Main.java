public class Main {
    public static void main(String[] args) {
        // Tạo 2 đối tượng NumberGenerator
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();

        // Tạo 2 Thread với generator làm tham số
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

        // Đặt độ ưu tiên
        thread1.setPriority(Thread.MAX_PRIORITY); // Ưu tiên cao nhất
        thread2.setPriority(Thread.MIN_PRIORITY); // Ưu tiên thấp nhất

        // Khởi động 2 luồng
        thread1.start();
        thread2.start();
    }
}
