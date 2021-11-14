package ru.job4j.ood.isp.menu;

import java.util.List;

public interface SubMenuPrinter {
    void printItem(StringBuilder sb, Menu.Item item, int count);

    String toString(List<Menu.Item> list);
}
