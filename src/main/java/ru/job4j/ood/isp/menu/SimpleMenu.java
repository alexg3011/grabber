package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenu implements Menu {
    private List<Item> list = new ArrayList<>();

    @Override
    public void add(String parentName, String childName, Action action) {
        if (list.isEmpty()) {
            list.add(new Item(parentName, childName, new ArrayList<>(), action));
        } else {
            addChild(parentName, new Item(parentName, childName, new ArrayList<>(), action), list);
        }
    }

    private void addChild(String parentName, Item child, List<Item> list) {
        for (Item item : list) {
            if (item.getName().equals(parentName)) {
                item.addItem(child);
            } else {
                addChild(parentName, child, item.getItemList());
            }
        }
    }

    public Action select(String itemName, List<Item> items) {
        Action action = null;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                action = item.getAction();
                action.action();
                break;
            }
            if (!item.getItemList().isEmpty()) {
                select(itemName, item.getItemList());
            }
        }
        return action;
    }

    public List<Item> getList() {
        return list;
    }
}
