package edu.epam.entity;

public enum ComputerCaseType {
    PC_BLOCK(20, "Case: PC-Block"),
    MINI_PC_BLOCK(50, "Case: Mini PC-Block");

    private double price;
    private String caseName;

    ComputerCaseType(double price, String caseName) {
        this.price = price;
        this.caseName = caseName;
    }

    public double getPrice() {
        return price;
    }

    public String getCaseName() {
        return caseName;
    }
}
