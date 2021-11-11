package ru.job4j.ood.isp.menu;

public interface SubMenuPrinter {
    void printItem(StringBuilder sb, Menu.Item item, int count);

    String toString();
}
