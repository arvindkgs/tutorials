package com.baeldung.hexagonal.domain;

import java.util.Random;

public class Item {
    
    private int id;
    private int amount;
    private int quantity;

    public Item(int amount, int quantity) {
        id = new Random().nextInt();
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }
}
