package com.example.baitapungdungquanlysanpham.service;

import com.example.baitapungdungquanlysanpham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 14 Pro Max", 3000, "Mô tả sản phẩm Iphone 14 Pro Max", "Apple"));
        products.add(new Product(2, "Samsung Galaxy S23 Ultra", 2500, "Mô tả sản phẩm Samsung Galaxy S23 Ultra", "Samsung"));
        products.add(new Product(3, "Google Pixel 7 Pro", 2000, "Mô tả sản phẩm Google Pixel 7 Pro", "Google"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(int id, Product product) {
        Product existing = findById(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setManufacturer(product.getManufacturer());
        }
    }

    @Override
    public void remove(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
