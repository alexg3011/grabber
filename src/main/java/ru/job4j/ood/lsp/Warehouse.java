package ru.job4j.ood.lsp;

import java.util.List;

public class Warehouse implements Storage {
    private List<Food> warehouse;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = Calculator.run(food);
        if (interest < 25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAll() {
        return warehouse;
    }

    @Override
    public void clean() {
        warehouse.clear();
    }
}
