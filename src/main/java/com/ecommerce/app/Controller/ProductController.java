package com.ecommerce.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> searchProduct(@PathVariable String productId) {
        Product foundProdcut = productService.searchProduct(productId);
        if(foundProdcut != null) {
            return ResponseEntity.ok(foundProdcut);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
