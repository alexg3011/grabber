package ru.job4j.ood.lsp.parking;

public class Car implements Transport {
    private final String name;
    public static final int CAR_SIZE = 1;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return CAR_SIZE;
    }

    public String getName() {
        return name;
    }
}
