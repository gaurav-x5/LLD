package org.example;

import java.util.List;

public abstract class ShoppingKartDecorator implements ShoppingKart{
    protected ShoppingKart shoppingKart;

    public ShoppingKartDecorator(ShoppingKart shoppingKart) {
        this.shoppingKart = shoppingKart;
    }


    @Override
    public void addProduct(Product product) {
        shoppingKart.addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        shoppingKart.removeProduct(product);
    }

    @Override
    public double calculatePrice() {
        return shoppingKart.calculatePrice();
    }

    @Override
    public List<Product> getItems() {
        return shoppingKart.getItems();
    }
}
