package com.ecommerce.app.Entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Product {
    @Id
    private String productId;
    private String productName;
    private Double price;

    @Override
    public String toString() {
        return  "Barcode ='" + productId + '\'' +
                ", Nama ='" + productName + '\'' +
                ", Harga =" + price;
    }
}
