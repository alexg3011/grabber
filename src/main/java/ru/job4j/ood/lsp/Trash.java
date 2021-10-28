package ru.job4j.ood.lsp;

import java.util.List;

public class Trash implements Strategy {
    private List<Food> trash;
    private Calculator calculator;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        float interest = calculator.run(food);
        if (interest >= 100) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }
}
