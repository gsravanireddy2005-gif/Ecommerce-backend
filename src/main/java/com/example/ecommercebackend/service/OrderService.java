package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.*;
import com.example.ecommercebackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Order> getOrders(User user) {
        return orderRepository.findByUserOrderByCreatedAtDesc(user);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Transactional
    public Order placeOrder(User user, String address, String paymentMethod) {
        List<CartItem> cartItems = cartItemRepository.findByUser(user);
        if (cartItems.isEmpty()) throw new RuntimeException("Cart is empty");

        Order order = new Order();
        order.setUser(user);
        order.setStatus("CONFIRMED");
        order.setAddress(address);
        order.setPaymentMethod(paymentMethod);
        order.setCreatedAt(LocalDateTime.now());

        double total = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
        }

        cartItemRepository.deleteAll(cartItems);

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle("Order Confirmed! 🎉");
        notification.setMessage("Your order #" + savedOrder.getId() + " has been placed successfully. Total: $" + String.format("%.2f", total));
        notification.setType("ORDER");
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);

        return savedOrder;
    }
}