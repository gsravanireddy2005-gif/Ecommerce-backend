package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.Notification;
import com.example.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserOrderByCreatedAtDesc(User user);
    long countByUserAndIsRead(User user, boolean isRead);
}