package com.example.ecommercebackend.config;

import com.example.ecommercebackend.model.Product;
import com.example.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {

            // Electronics
            productRepository.save(create("iPhone 15 Pro", "6.1-inch Super Retina XDR, A17 Pro chip, 48MP camera", 999.99, "https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400", "Electronics", 25, 4.9));
            productRepository.save(create("Samsung Galaxy S24", "6.2-inch Dynamic AMOLED, Snapdragon 8 Gen 3", 849.99, "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=400", "Electronics", 30, 4.7));
            productRepository.save(create("MacBook Air M3", "13.6-inch Liquid Retina, Apple M3 chip, 8GB RAM", 1099.99, "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=400", "Electronics", 15, 4.8));
            productRepository.save(create("Sony WH-1000XM5", "Industry-leading noise cancelling headphones", 349.99, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400", "Electronics", 40, 4.8));
            productRepository.save(create("iPad Pro 12.9", "M2 chip, Liquid Retina XDR display, 5G capable", 1099.99, "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400", "Electronics", 20, 4.7));
            productRepository.save(create("Mechanical Keyboard", "RGB backlit tactile switches, compact TKL", 149.99, "https://images.unsplash.com/photo-1618384887929-16ec33fab9ef?w=400", "Electronics", 25, 4.6));
            productRepository.save(create("Portable Speaker", "360 surround sound, waterproof, 24hr battery", 69.99, "https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=400", "Electronics", 35, 4.5));
            productRepository.save(create("Smart Watch Series 9", "Always-on display, health monitoring, GPS", 399.99, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400", "Electronics", 15, 4.8));

            // Footwear
            productRepository.save(create("Nike Air Max 270", "Lightweight foam midsole, Max Air unit", 150.00, "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400", "Footwear", 50, 4.6));
            productRepository.save(create("Adidas Ultraboost 23", "Responsive Boost midsole, Primeknit upper", 180.00, "https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=400", "Footwear", 40, 4.7));
            productRepository.save(create("Puma RS-X", "Retro running design, chunky sole", 110.00, "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?w=400", "Footwear", 35, 4.4));
            productRepository.save(create("Converse Chuck 70", "Premium canvas, cushioned footbed", 85.00, "https://images.unsplash.com/photo-1463100099107-aa0980c362e6?w=400", "Footwear", 60, 4.5));
            productRepository.save(create("Leather Chelsea Boots", "Full-grain leather, elastic side panels", 220.00, "https://images.unsplash.com/photo-1638247025967-b4e38f787b76?w=400", "Footwear", 20, 4.6));

            // Clothing
            productRepository.save(create("Premium Denim Jacket", "Classic slim fit, 100% cotton denim", 89.99, "https://images.unsplash.com/photo-1576995853123-5a10305d93c0?w=400", "Clothing", 40, 4.5));
            productRepository.save(create("Linen Oversized Shirt", "Breathable summer linen, relaxed fit", 65.00, "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400", "Clothing", 55, 4.3));
            productRepository.save(create("Merino Wool Sweater", "Ultra-soft, temperature regulating", 120.00, "https://images.unsplash.com/photo-1434389677669-e08b4cac3105?w=400", "Clothing", 30, 4.7));
            productRepository.save(create("Slim Chino Pants", "Stretch cotton, 5-pocket styling", 75.00, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400", "Clothing", 45, 4.4));
            productRepository.save(create("Graphic Tee Collection", "100% organic cotton, artistic prints", 35.00, "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?w=400", "Clothing", 100, 4.3));

            // Accessories
            productRepository.save(create("Aviator Sunglasses", "UV400 polarized, stainless steel frame", 129.99, "https://images.unsplash.com/photo-1572635196237-14b3f281503f?w=400", "Accessories", 80, 4.6));
            productRepository.save(create("Slim Leather Wallet", "RFID blocking, genuine full-grain leather", 79.99, "https://images.unsplash.com/photo-1627123424574-724758594e93?w=400", "Accessories", 90, 4.5));
            productRepository.save(create("Gold Chain Necklace", "18k gold plated, 45cm chain", 89.99, "https://images.unsplash.com/photo-1599643478518-a784e5dc4c8f?w=400", "Accessories", 50, 4.4));
            productRepository.save(create("Leather Belt", "Full grain leather, brushed silver buckle", 55.00, "https://images.unsplash.com/photo-1624222247344-550fb60fe8ff?w=400", "Accessories", 70, 4.3));
            productRepository.save(create("Silk Scarf", "100% mulberry silk, hand-rolled edges", 95.00, "https://images.unsplash.com/photo-1584030373081-f37b614f5c1a?w=400", "Accessories", 35, 4.6));

            // Bags
            productRepository.save(create("Leather Backpack", "Full-grain leather, 30L waterproof", 195.00, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400", "Bags", 20, 4.7));
            productRepository.save(create("Canvas Tote Bag", "Heavy duty waxed canvas, magnetic closure", 75.00, "https://images.unsplash.com/photo-1591561954557-26941169b49e?w=400", "Bags", 45, 4.4));
            productRepository.save(create("Crossbody Messenger", "Waxed canvas, multiple compartments", 110.00, "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=400", "Bags", 30, 4.5));

            // Sports
            productRepository.save(create("Yoga Mat Premium", "6mm non-slip, alignment lines, carry strap", 59.99, "https://images.unsplash.com/photo-1601925260368-ae2f83cf8b7f?w=400", "Sports", 60, 4.6));
            productRepository.save(create("Resistance Band Set", "5 levels, latex free, door anchor included", 34.99, "https://images.unsplash.com/photo-1598289431512-b97b0917affc?w=400", "Sports", 80, 4.4));
            productRepository.save(create("Water Bottle 32oz", "Insulated stainless steel, leak-proof lid", 39.99, "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=400", "Sports", 100, 4.5));

            // Kitchen & Home
            productRepository.save(create("Pour Over Coffee Set", "Borosilicate glass, wooden collar, filters", 65.00, "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=400", "Kitchen", 40, 4.7));
            productRepository.save(create("Insulated Coffee Mug", "12hr hot, 24hr cold, leak-proof lid", 34.99, "https://images.unsplash.com/photo-1514228742587-6b1558fcca3d?w=400", "Kitchen", 75, 4.5));
            productRepository.save(create("Scented Candle Set", "Soy wax, 3 premium scents, 40hr burn", 49.99, "https://images.unsplash.com/photo-1603905710391-3b67a80a5c4d?w=400", "Home", 80, 4.6));
        }
    }

    private Product create(String name, String desc, Double price, String img, String cat, Integer stock, Double rating) {
        Product p = new Product();
        p.setName(name); p.setDescription(desc);
        p.setPrice(price); p.setImageUrl(img);
        p.setCategory(cat); p.setStock(stock);
        return p;
    }
}