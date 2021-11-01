package ru.job4j.ood.isp.menu;

import java.util.List;

public class ShowMenu implements Show {

    @Override
    public void showMenu(List<Item> listMenu) {
        for (Item item : listMenu) {
            System.out.println(item.getName());
            if (!item.getChildrenItems().isEmpty()) {
                showMenu(item.getChildrenItems());
            }
        }
    }
}
