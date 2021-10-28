package ru.job4j.ood.lsp;

public class ControlQuality {

    private Strategy strategy;

    public ControlQuality(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Food food) {
        return strategy.add(food);
    }
}
