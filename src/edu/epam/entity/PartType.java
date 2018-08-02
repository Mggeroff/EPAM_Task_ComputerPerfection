package edu.epam.entity;

public enum PartType {
    CPU(50, "CPU"),
    RAM_MODULES(20, "RAM Modules"),
    GRAPHICS_CARD(100, "Graphics Card"),
    POWER_SUPPLY(30, "Power Supply"),
    MOTHERBOARD(70, "Motherboard"),
    CD_DVD_DRIVE(15, "CD/DVD Drive"),
    HARD_DRIVE(40, "Hard Drive"),
    PCI_DEVICE(10, "PCI Device");


    private double price;
    private String partName;
    PartType(double price, String partName) {
        this.price = price;
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public String getPartName() {
        return partName;
    }

    enum ComputerCase {
        PC_BLOCK(20, "Case: PC-Block"),
        MINI_PC_BLOCK(50, "Case: Mini PC-Block");
        private double price;
        private String caseName;

        ComputerCase(double price, String caseName) {
            this.price = price;
            this.caseName = caseName;
        }
    }

}
