package edu.epam.entity;

import java.util.Random;

public class IdGenerator<T> {
    private static final int MIN_ORDER_LENGTH = 10000;
    private static final int MAX_ORDER_LENGTH = 100000;
    private Random random = new Random();

    public int generateOrderId() {
        return generator();
    }

    public int generateClientId() {
        return generator();
    }

    private int generator() {
        return MIN_ORDER_LENGTH + random.nextInt(MAX_ORDER_LENGTH - MIN_ORDER_LENGTH);
    }
}
