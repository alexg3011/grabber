package ru.job4j.ood.isp.menu;

import java.util.List;

public class Item {
    private String name;
    private List<Item> childrenItems;
    private Action action;

    public Item(String name, List<Item> childrenList, Action action) {
        this.name = name;
        this.childrenItems = childrenList;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getChildrenItems() {
        return childrenItems;
    }

    public void setChildrenItems(List<Item> childrenItems) {
        this.childrenItems = childrenItems;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
