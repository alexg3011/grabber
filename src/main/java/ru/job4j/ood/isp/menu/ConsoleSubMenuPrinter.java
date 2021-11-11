package ru.job4j.ood.isp.menu;

import java.util.List;

public class ConsoleSubMenuPrinter implements SubMenuPrinter {

    public void printItem(StringBuilder sb, Menu.Item item, int count) {
        sb.append("----".repeat(count))
                .append(" ")
                .append(item.getName())
                .append("\n");

        if (!item.getChildList().isEmpty()) {
            count++;
            for (Menu.Item child : item.getChildList()) {
                printItem(sb, child, count);
            }
        }
    }

    @Override
    public String toString() {
        List<Menu.Item> items = SimpleMenu.ITEMS;
        StringBuilder sb = new StringBuilder();
        if (!items.isEmpty()) {
            for (Menu.Item item : items) {
                printItem(sb, item, 0);
            }
        }
        return sb.toString();
    }
}
