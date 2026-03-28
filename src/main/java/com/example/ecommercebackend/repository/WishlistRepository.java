package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.WishlistItem;
import com.example.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistItem, Long> {
    List<WishlistItem> findByUser(User user);
    boolean existsByUserAndProductId(User user, Long productId);

    @Transactional
    void deleteByUserAndProductId(User user, Long productId);
}