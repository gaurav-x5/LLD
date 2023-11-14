package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingKartImpl implements ShoppingKart{
    List<Product> cart;

    public ShoppingKartImpl() {
        this.cart = new ArrayList<>();
    }
    @Override
    public void addProduct(Product product) {
        cart.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        cart.remove(product);
    }

    @Override
    public double calculatePrice() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public List<Product> getItems() {
        return cart;
    }
}
