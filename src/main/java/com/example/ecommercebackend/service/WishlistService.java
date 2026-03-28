package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.*;
import com.example.ecommercebackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<WishlistItem> getWishlist(User user) {
        return wishlistRepository.findByUser(user);
    }

    public WishlistItem addToWishlist(User user, Long productId) {
        if (wishlistRepository.existsByUserAndProductId(user, productId)) {
            return null;
        }
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        WishlistItem item = new WishlistItem();
        item.setUser(user);
        item.setProduct(product);
        return wishlistRepository.save(item);
    }

    public void removeFromWishlist(User user, Long productId) {
        wishlistRepository.deleteByUserAndProductId(user, productId);
    }

    public boolean isInWishlist(User user, Long productId) {
        return wishlistRepository.existsByUserAndProductId(user, productId);
    }
}