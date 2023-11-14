package org.example;

import java.util.List;

public interface ShoppingKart {
    void addProduct(Product product);
    void removeProduct(Product product);

    double calculatePrice();
    List<Product> getItems();
}
