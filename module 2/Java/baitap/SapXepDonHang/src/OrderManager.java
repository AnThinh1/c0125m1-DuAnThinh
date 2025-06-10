import java.util.*;

public class OrderManager {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("DH001", 500.0));
        orders.add(new Order("DH002", 1500.0));
        orders.add(new Order("DH003", 750.0));
        orders.add(new Order("DH004", 1200.0));
        orders.add(new Order("DH005", 300.0));

        //  Bubble Sort theo tổng tiền giảm dần
        bubbleSortOrders(orders);

        System.out.println("Danh sách đơn hàng sau khi sắp xếp:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // (Tuỳ chọn) Tìm đơn hàng có tổng tiền cao nhất
        Order maxOrder = orders.get(0); // sau khi sắp xếp giảm dần thì phần tử đầu là lớn nhất
        System.out.println("\nĐơn hàng có tổng tiền cao nhất: " + maxOrder);

    }

    //  Hàm bubble sort
    public static void bubbleSortOrders(List<Order> orders) {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders.get(j).getTotalAmount() < orders.get(j + 1).getTotalAmount()) {
                    // hoán đổi
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }
}
