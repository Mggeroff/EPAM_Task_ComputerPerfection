package edu.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponentAddition {
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 20;
    private static final String DEFAULT_NAME = "Client ";

    private List<PartType> components = new ArrayList<>();
    private String computerName;
    private int numberOfComputers;
    private int price;

    public Computer(String computerName, int numberOfComputers) {
        if (computerName.length() < MIN_SIZE || computerName.length() > MAX_SIZE) {
            this.computerName = DEFAULT_NAME + clientId;
        } else {
            this.numberOfComputers = numberOfComputers;
        }
        this.computerName = computerName;
        this.numberOfComputers = numberOfComputers;
    }

    @Override
    public Computer addComponent(PartType component) {
        components.add(component);
        price += component.getPrice();
        return this;
    }

    public int getPrice() {
        return price;
    }

//    public List<String> getPartsNames() {
//        for (PartType component : components) {
//            parts.add(component.getPartName());
//        }
//
//        return parts;
//    }
}

