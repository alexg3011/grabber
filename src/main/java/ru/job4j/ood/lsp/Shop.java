package ru.job4j.ood.lsp;

import java.util.List;

public class Shop implements Strategy {

    private List<Food> shop;
    private Calculator calculator;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = calculator.run(food);
        if (interest >= 25 && interest <= 75) {
            shop.add(food);
        } else if (interest >= 75 && interest < 100) {
            food.setDiscount(true);
            food.setPrice(food.getPrice() * 50 / 100);
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }
}

