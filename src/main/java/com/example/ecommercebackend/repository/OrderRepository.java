package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.Order;
import com.example.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByCreatedAtDesc(User user);
}