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

    public void resort() {
        for (Storage storage : storages) {
            List<Food> foodList = storage.getAll();
            storage.clean();
            foodList.forEach(this::distribute);
        }
    }
}
