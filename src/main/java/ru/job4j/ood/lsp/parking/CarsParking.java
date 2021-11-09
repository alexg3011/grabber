package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.parking.Car.CAR_SIZE;

public class CarsParking implements Parking {
    private int carPlace;
    private int truckPlace;
    private List<Transport> transports = new ArrayList<>();

    public CarsParking(int carPlace, int truckPlace) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean park(Transport transport) {
        boolean rsl = false;
        int size = transport.getSize();
        if (size == CAR_SIZE && carPlace > 0) {
            carPlace--;
            transports.add(transport);
            rsl = true;
        } else if (size > CAR_SIZE && truckPlace > 0) {
            truckPlace--;
            transports.add(transport);
            rsl = true;
        } else if (size > CAR_SIZE && carPlace >= size) {
            carPlace -= size;
            transports.add(transport);
            rsl = true;
        }
        return rsl;
    }

    public int getCarPlace() {
        return carPlace;
    }

    public int getTruckPlace() {
        return truckPlace;
    }
}
