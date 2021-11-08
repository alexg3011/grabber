package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Objects;

public interface Menu {
    void add(String parentName, String childName, Action action);
    Action select(String itemName, List<Item> list);

    class Item {
        private final String parentName;
        private final String name;
        List<Item> itemList;
        Action action;

        public Item(String parentName, String name, List<Item> itemList, Action action) {
            this.parentName = parentName;
            this.name = name;
            this.itemList = itemList;
            this.action = action;
        }

        public String getName() {
            return name;
        }

        public List<Item> getItemList() {
            return itemList;
        }

        public void setItemList(List<Item> itemList) {
            this.itemList = itemList;
        }

        public Action getAction() {
            return action;
        }

        public void setAction(Action action) {
            this.action = action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Item item = (Item) o;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public void addItem(Item child) {
            itemList.add(child);
        }

        public String getParentName() {
            return parentName;
        }
    }
}

