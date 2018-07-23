package edu.epam.entity;

public enum Parts {
    CPU(50),
    RAM_MODULES(20),
    GRAPHICS_CARD(100),
    POWER_SUPPLY(30),
    MOTHERBOARD(70),
    CD_DVD_DRIVE(15),
    HARD_DRIVE(40),
    PCI_DEVICE(10),
    PC_BLOCK(20),
    MINI_PC_BLOCK(50);

    private double price;

    Parts(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
