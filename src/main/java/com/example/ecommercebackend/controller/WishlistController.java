package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.repository.UserRepository;
import com.example.ecommercebackend.service.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserRepository userRepository;

    private User getSessionUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return null;
        return userRepository.findById(userId).orElse(null);
    }

    @GetMapping
    public ResponseEntity<?> getWishlist(HttpSession session) {
        User user = getSessionUser(session);
        if (user == null) return ResponseEntity.status(401).body(Map.of("error", "Not logged in"));
        return ResponseEntity.ok(wishlistService.getWishlist(user));
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<?> add(@PathVariable Long productId, HttpSession session) {
        User user = getSessionUser(session);
        if (user == null) return ResponseEntity.status(401).body(Map.of("error", "Not logged in"));
        wishlistService.addToWishlist(user, productId);
        return ResponseEntity.ok(Map.of("message", "Added to wishlist"));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> remove(@PathVariable Long productId, HttpSession session) {
        User user = getSessionUser(session);
        if (user == null) return ResponseEntity.status(401).body(Map.of("error", "Not logged in"));
        wishlistService.removeFromWishlist(user, productId);
        return ResponseEntity.ok(Map.of("message", "Removed from wishlist"));
    }

    @GetMapping("/check/{productId}")
    public ResponseEntity<?> check(@PathVariable Long productId, HttpSession session) {
        User user = getSessionUser(session);
        if (user == null) return ResponseEntity.ok(Map.of("inWishlist", false));
        return ResponseEntity.ok(Map.of("inWishlist", wishlistService.isInWishlist(user, productId)));
    }
}