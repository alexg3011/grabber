package main.ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.lsp.parking.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Ignore
public class TestParking {

    @Test
    public void whenCarParking() {
        Transport car = new Car("VAZ", 1);
        Parking parking = new CarsParking(1, 0);
        assertTrue(parking.park(car));
    }

    @Test
    public void whenTruckParking() {
        Transport truck = new Truck("Belaz", 3);
        Parking parking = new CarsParking(0, 3);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenTruckParkInCarPlace() {
        Transport truck = new Truck("Belaz", 3);
        Parking parking = new CarsParking(3, 0);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenNoPlaceForCar() {
        Transport car = new Car("Vaz", 1);
        Parking parking = new CarsParking(0, 0);
        assertFalse(parking.park(car));
    }

    @Test
    public void whenToLittleSpaceForTruck() {
        Transport truck = new Truck("Belaz", 3);
        Parking parking = new CarsParking(2, 0);
        assertFalse(parking.park(truck));
    }
}
