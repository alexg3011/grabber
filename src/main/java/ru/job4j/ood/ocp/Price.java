package ru.job4j.ood.ocp;

/* Нарушение принципа ocp, тк скидка может быть другой
и придется переписывать метод или писать новый */

public class Price {
    public double discount(double price) {
        return price * 0.7;
    }
}

