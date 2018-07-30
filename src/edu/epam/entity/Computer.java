package edu.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponentAddition {
    private List<PartType> components = new ArrayList<>();
    private int price;

    @Override
    public Computer addComponent(PartType component) {
        components.add(component);
        price += component.getPrice();
        return this;
    }

    public int getPrice() {
        return price;
    }
}

