package ru.job4j.ood.lsp;

public class Calculator {

    public static float run(Food food) {
        long differenceOne = food.getExpiryDate().getTime() - food.getCreateDate().getTime();
        long differenceTwo = System.currentTimeMillis() - food.getCreateDate().getTime();
        return ((float) differenceTwo / differenceOne) * 100;
    }
}
