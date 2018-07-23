package edu.epam.entity;

import java.util.ArrayList;

public class Computer implements ComputerComponentAddition {
    private ArrayList<Parts> components = new ArrayList<>();
    private int price;

    @Override
    public Computer addComponent(Parts component) {
        components.add(component);
        price += component.getPrice();
        return this;
    }

    public int getPrice() {
        return price;
    }
}

