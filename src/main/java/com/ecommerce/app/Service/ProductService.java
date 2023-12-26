package com.ecommerce.app.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private ArrayList<Product> shoppingCart; 

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product searchProduct(String productId) {
        return productRepository.findByProductId(productId);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void addProductToCart(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product != null) {
            shoppingCart.add(product);
        }
    }

    public List<Product> getShoppingCartItems() {
        return shoppingCart;
    }
}
