package ru.job4j.ood.lsp;

import java.util.List;

public class Shop implements Storage {

    private List<Food> shop;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = Calculator.run(food);
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

    @Override
    public List<Food> getAll() {
        return shop;
    }

    @Override
    public void clean() {
        shop.clear();
    }
}

