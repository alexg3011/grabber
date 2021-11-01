package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

/* Нарушение DIP, в листе используется конкретный класс вместо общего интерфейса */

public class Transport {
        List<Car> carList = new ArrayList<>();

        class Car {
        }
}
