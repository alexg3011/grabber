package ru.job4j.ood.lsp.parking;

public class CarsParking implements Parking {
    private final int forCar;
    private final int forTruck;

    public CarsParking(int forCar, int forTruck) {
        this.forCar = forCar;
        this.forTruck = forTruck;
    }

    @Override
    public boolean park(Transport transport) {
        return false;
    }

    public int getForCar() {
        return forCar;
    }

    public int getForTruck() {
        return forTruck;
    }
}
