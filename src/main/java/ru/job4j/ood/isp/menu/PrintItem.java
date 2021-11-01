package ru.job4j.ood.isp.menu;

import java.util.List;

public class PrintItem implements Menu {
    private final String select;

    public PrintItem(String str) {
        this.select = str;
    }

    @Override
    public void printAction(List<Item> listMenu) {
        for (Item item : listMenu) {
            if (item.getName().endsWith(select)) {
                item.getAction().action();
                break;
            }
            if (!item.getChildrenItems().isEmpty()) {
                printAction(item.getChildrenItems());
            }
        }
    }
}
