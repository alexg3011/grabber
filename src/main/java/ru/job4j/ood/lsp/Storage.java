package ru.job4j.ood.lsp;

import java.util.List;

public interface Storage {

    boolean add(Food food);

    List<Food> getAll();

    void clean();
}
