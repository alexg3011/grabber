package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.List;

public class SimpleMenu implements Menu {

    private final List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    @Override
    public void add(String parentName, String childName, Action action) {
        Item parent = findItemByName(parentName);
        if (parent != null) {
            parent.addChild(new Item(childName, action));
        } else {
            items.add(new Item(childName, action));
        }
    }

    @Override
    public Action select(String name) {
        Action action = null;
        Item item = findItemByName(name);
        if (item != null) {
            action = item.getAction();
        }
        return action;
    }

    private Item findItemByName(String name) {
        Item rsl = null;
        for (Item item : items) {
            Item it = findIntoItem(item, name);
            if (it != null) {
                rsl = it;
                break;
            }
        }
        return rsl;
    }

    private Item findIntoItem(Item item, String name) {
        Item rsl = null;
        if (item.getName().equals(name)) {
            rsl = item;
        } else if (item.getChildList().size() > 0) {
            for (Item it : item.getChildList()) {
                Item child = findIntoItem(it, name);
                if (child != null) {
                    rsl = child;
                    break;
                }
            }
        }
        return rsl;
    }
}
