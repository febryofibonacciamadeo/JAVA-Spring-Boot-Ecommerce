package com.ecommerce.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Entity.User;
import com.ecommerce.app.Service.ProductService;

@Controller
public class ViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product")
    public String showProductListing(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "products";
    }

    @GetMapping("/product/add")
    public String add_product(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model) {
        List<Product> shoppingCart = productService.getShoppingCartItems();
        model.addAttribute("shoppingCart", shoppingCart);
        return "shopping-cart";
    }
}
