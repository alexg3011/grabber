package ru.job4j.ood.lsp;

import java.util.List;

public class Warehouse implements Strategy {
    private List<Food> warehouse;
    private Calculator calculator;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = calculator.run(food);
        if (interest < 25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }
}
