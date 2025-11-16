package com.codegym.commencalstore.controller;

import com.codegym.commencalstore.model.Bike;
import com.codegym.commencalstore.model.Order;
import com.codegym.commencalstore.model.OrderItem;
import com.codegym.commencalstore.service.BikeService;
import com.codegym.commencalstore.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final BikeService bikeService;
    private final OrderService orderService;

    public OrderController(BikeService bikeService, OrderService orderService) {
        this.bikeService = bikeService;
        this.orderService = orderService;
    }

    // Thêm xe vào giỏ hàng
    @PostMapping("/add-to-cart/{bikeId}")
    public String addToCart(@PathVariable Long bikeId,
                            @RequestParam int quantity,
                            HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        Bike bike = bikeService.findById(bikeId);
        if (bike != null) {
            cart.add(new CartItem(bike, quantity));
            session.setAttribute("cart", cart);
        }
        return "redirect:/orders";
    }

    // Xem giỏ hàng
    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        model.addAttribute("cart", cart);
        return "order/cart";
    }

    // Xóa 1 item trong giỏ hàng
    @GetMapping("/remove/{index}")
    public String removeFromCart(@PathVariable int index, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null && index >= 0 && index < cart.size()) {
            cart.remove(index);
            session.setAttribute("cart", cart);
        }
        return "redirect:/orders";
    }

    // Hiển thị form checkout
    @GetMapping("/checkout-form")
    public String checkoutForm(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) return "redirect:/bikes";
        model.addAttribute("cart", cart);
        return "order/checkout";
    }

    // Xử lý checkout
    @PostMapping("/checkout")
    public String checkout(@RequestParam String customerName,
                           @RequestParam String customerEmail,
                           @RequestParam String customerPhone,
                           @RequestParam String customerAddress,
                           HttpSession session) {

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) return "redirect:/bikes";

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem item : cart) {
            OrderItem oi = OrderItem.builder()
                    .bike(item.getBike())
                    .quantity(item.getQuantity())
                    .build();
            orderItems.add(oi);
        }

        Order order = Order.builder()
                .customerName(customerName)
                .customerEmail(customerEmail)
                .customerPhone(customerPhone)
                .customerAddress(customerAddress)
                .orderItems(orderItems)
                .build();

        orderService.createOrder(order);

        session.removeAttribute("cart"); // clear cart
        return "order/success";
    }

    // Danh sách đơn hàng
    @GetMapping("/list")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order/list";
    }

    // Class CartItem trong session
    public static class CartItem {
        private Bike bike;
        private int quantity;

        public CartItem(Bike bike, int quantity) {
            this.bike = bike;
            this.quantity = quantity;
        }
        public Bike getBike() { return bike; }
        public int getQuantity() { return quantity; }
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders/list";
    }
    @GetMapping("/detail/{id}")
    public String viewOrderDetail(@PathVariable Long id, Model model) {
        Order order = orderService.getAllOrders().stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Đơn hàng không tồn tại"));

        // Tạo CartItem để dùng lại template cart.html
        List<CartItem> cartItems = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            cartItems.add(new CartItem(item.getBike(), item.getQuantity()));
        }

        model.addAttribute("cart", cartItems);
        model.addAttribute("readonly", true); // để template biết đang xem chi tiết, không edit
        return "order/cart"; // dùng lại template giỏ hàng
    }
}
