package ru.job4j.ood.isp.menu;

import java.util.List;

public class ShowMenu implements Show {
    @Override
    public void showMenu(List<Menu.Item> list) {
        for (Menu.Item item : list) {
            System.out.println(item.getName());
            showMenu(item.getItemList());
        }
    }
}
