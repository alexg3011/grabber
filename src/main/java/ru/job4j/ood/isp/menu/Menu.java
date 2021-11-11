package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.List;

public interface Menu {
    void add(String parentName, String childName, Action action);

    Action select(String itemName);

    class Item {
        private final String name;
        private final List<Item> childList = new LinkedList<>();
        private final Action action;

        Item(String name, Action action) {
            this.name = name;
            this.action = action;
        }

        public String getName() {
            return name;
        }

        public List<Item> getChildList() {
            return childList;
        }

        public Action getAction() {
            return action;
        }

        void addChild(Item item) {
            childList.add(item);
        }
    }
}

