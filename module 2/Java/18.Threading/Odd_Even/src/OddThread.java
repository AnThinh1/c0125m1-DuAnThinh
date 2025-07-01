public class OddThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Số lẻ: " + i);
            try {
                Thread.sleep(10); // nghỉ 10ms
            } catch (InterruptedException e) {
                System.out.println("OddThread bị gián đoạn");
            }
        }
    }
}
