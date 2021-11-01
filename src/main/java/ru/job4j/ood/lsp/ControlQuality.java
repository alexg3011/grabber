package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {
    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribute(Food food) {
        for (Storage storage : storages) {
            storage.add(food);
        }
    }
}
