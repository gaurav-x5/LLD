package org.example;

public class ShoppingKartDecoratorImpl extends ShoppingKartDecorator{

    public double discount;
    public ShoppingKartDecoratorImpl(ShoppingKart shoppingKart, double discount) {
        super(shoppingKart);
        this.discount = discount;
    }

    @Override
    public double calculatePrice() {
        double originalTotal = shoppingKart.calculatePrice();
        return originalTotal * (1 - discount);
    }
}
