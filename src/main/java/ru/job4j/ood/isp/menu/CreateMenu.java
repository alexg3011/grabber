package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateMenu implements Menu {
    private static List<Item> list = new ArrayList<>();

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

    public void init(List<Item> items, Scanner scanner) {
        boolean run = true;
        Show show = new ShowMenu();
        while (run) {
            System.out.println("Select: ");
            show.showMenu(items);
            String sel = scanner.nextLine();
            if (!sel.equals("Exit")) {
                select(sel, list);
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new CreateMenu();
        Action action = new DoAction();
        Action action1 = new NothingAction();
        CreateMenu show = new CreateMenu();
        menu.add("", "Задача 1.", action);
        menu.add("Задача 1.", "---- Задача 1.1.", action);
        menu.add("---- Задача 1.1.", "--------- Задача 1.1.1.", action);
        menu.add("---- Задача 1.1.", "--------- Задача 1.1.2.", action);
        menu.add("Задача 1.", "---- Задача 1.2.", action1);

        show.init(list, new Scanner(System.in));
    }
}
