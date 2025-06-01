public class Main {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch(); // bắt đầu

        Thread.sleep(2000); // Giả lập quá trình mất thời gian

        sw.stop(); // kết thúc

        System.out.println("Elapsed Time: " + sw.getElapsedTime() + " milliseconds");
    }
}
