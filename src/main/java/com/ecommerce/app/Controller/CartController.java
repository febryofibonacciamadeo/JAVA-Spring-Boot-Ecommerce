package com.ecommerce.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable String productId) {
        Product product = productService.searchProduct(productId);
        if (product != null) {
            return ResponseEntity.ok("Product added to the shopping cart successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}   
