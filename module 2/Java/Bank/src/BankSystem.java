import java.util.*;

public class BankSystem {
    private LinkedList<Customer> queue = new LinkedList<>();
    private List<Counter> counters = new ArrayList<>();
    private int currentNumber = 1;
    private Scanner scanner = new Scanner(System.in);

    public BankSystem() {
        for (int i = 1; i <= 5; i++) {
            counters.add(new Counter(i));
        }

        for (Counter counter : counters) {
            counter.serve(new Customer(currentNumber++, "Khách mở đầu"));
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm 10 khách hàng mới");
            System.out.println("2. Quầy xử lý xong → Gọi khách tiếp theo");
            System.out.println("3. Hiển thị hàng đợi hiện tại");
            System.out.println("4. Hiển thị trạng thái các quầy");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // bỏ dòng trống

            switch (choice) {
                case 1:
                    addCustomers(10);
                    break;
                case 2:
                    processNext();
                    break;
                case 3:
                    showQueue();
                    break;
                case 4:
                    showCounters();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private void addCustomers(int count) {
        for (int i = 0; i < count; i++) {
            String name = "Khách " + currentNumber;
            Customer customer = new Customer(currentNumber++, name);
            queue.add(customer);
        }
        System.out.println(count + " khách hàng đã được thêm vào hàng đợi.");
    }

    private void processNext() {
        for (Counter counter : counters) {
            if (!queue.isEmpty() && !counter.isBusy()) {
                Customer next = queue.poll();
                counter.serve(next);
                System.out.println("Quầy " + counter.getStatus());
            } else if (!queue.isEmpty() && counter.isBusy()) {
                counter.finish(); // kết thúc khách cũ
                Customer next = queue.poll(); // lấy khách mới
                counter.serve(next); // phục vụ
                System.out.println("Quầy " + counter.getStatus());
            }
        }
    }

    private void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi rỗng.");
        } else {
            System.out.println("Hàng đợi hiện tại:");
            for (Customer c : queue) {
                System.out.println(c);
            }
        }
    }

    private void showCounters() {
        for (Counter counter : counters) {
            System.out.println(counter.getStatus());
        }
    }
}
