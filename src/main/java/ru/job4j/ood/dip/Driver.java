package ru.job4j.ood.dip;

/* Нарушение DIP, нужно абстрагироваться от auto, тк могут быть другие виды транспорта */

public class Driver {
    String name;
    Auto auto;
}

class Auto {
    String model;
    String number;
}
