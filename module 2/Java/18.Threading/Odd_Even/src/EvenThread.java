public class EvenThread extends Thread {

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Số chẵn: " + i);
            try {
                Thread.sleep(15); // nghỉ 15ms
            } catch (InterruptedException e) {
                System.out.println("EvenThread bị gián đoạn");
            }
        }
    }
}
