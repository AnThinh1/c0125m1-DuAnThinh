package com.codegym.commencalstore.service;
import com.codegym.commencalstore.model.Order;
import com.codegym.commencalstore.model.OrderItem;
import com.codegym.commencalstore.model.Bike;
import com.codegym.commencalstore.repository.OrderRepository;
import com.codegym.commencalstore.repository.OrderItemRepository;
import com.codegym.commencalstore.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final BikeRepository bikeRepository;

    // Lấy danh sách tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Tạo đơn hàng mới
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());

        // ✅ Tính tổng giá và cập nhật số lượng xe
        double total = 0;
        for (OrderItem item : order.getOrderItems()) {
            Bike bike = bikeRepository.findById(item.getBike().getId())
                    .orElseThrow(() -> new RuntimeException("Xe không tồn tại!"));

            if (bike.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Không đủ hàng trong kho cho xe: " + bike.getName());
            }

            // trừ số lượng
            bike.setQuantity(bike.getQuantity() - item.getQuantity());
            bikeRepository.save(bike);

            // set giá từng item
            item.setPrice(bike.getPrice() * item.getQuantity());
            item.setOrder(order);
            total += item.getPrice();
        }

        order.setTotalPrice(total);
        return orderRepository.save(order);
    }

    // Xoá đơn hàng (và cộng lại số lượng xe)
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn hàng không tồn tại"));

        for (OrderItem item : order.getOrderItems()) {
            Bike bike = item.getBike();
            bike.setQuantity(bike.getQuantity() + item.getQuantity());
            bikeRepository.save(bike);
        }

        orderRepository.delete(order);
    }


    }
