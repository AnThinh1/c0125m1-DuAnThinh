public class NumberGenerator implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Số: " + i + " | hashCode: " + this.hashCode());
            try {
                Thread.sleep(500); // Nghỉ 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread bị gián đoạn");
            }
        }
    }
}
