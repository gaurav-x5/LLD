package org.example;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 500);

        ShoppingKart cart = new ShoppingKartImpl();
        cart.addProduct(laptop);
        cart.addProduct(phone);

        System.out.println("Total before discount: " + cart.calculatePrice());

        // Applying a 10% discount using the Decorator pattern
        ShoppingKart discountedCart = new ShoppingKartDecoratorImpl(cart, 0.10) {
        };

        System.out.println("Total after discount: " + discountedCart.calculatePrice());
    }
}