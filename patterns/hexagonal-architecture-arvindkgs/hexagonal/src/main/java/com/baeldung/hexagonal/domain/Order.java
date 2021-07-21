package com.baeldung.hexagonal.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int id;
    private List<Item> items;

    public Order() {
        id = new Random().nextInt();
        items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }
}
