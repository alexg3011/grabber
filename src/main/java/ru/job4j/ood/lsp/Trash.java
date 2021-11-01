package ru.job4j.ood.lsp;

import java.util.List;

public class Trash implements Storage {
    private List<Food> trash;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = Calculator.run(food);
        if (interest >= 100) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAll() {
        return trash;
    }

    @Override
    public void clean() {
        trash.clear();
    }
}
