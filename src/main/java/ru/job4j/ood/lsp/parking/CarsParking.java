package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

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
        if (size == 1 && carPlace > 0) {
            carPlace--;
            transports.add(transport);
            rsl = true;
        } else if (size > 1 && truckPlace >= size) {
            truckPlace -= size;
            transports.add(transport);
            rsl = true;
        } else if (size > 1 && carPlace >= size) {
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
