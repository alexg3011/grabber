package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Scanner;

public class MenuApplication {

    public void init(List<Menu.Item> items, Scanner scanner) {
        boolean run = true;
        SubMenuPrinter show = new ConsoleSubMenuPrinter();
        SimpleMenu simpleMenu = new SimpleMenu();
        while (run) {
            System.out.println("Select: ");
            show.showMenu(items);
            String sel = scanner.nextLine();
            if (!sel.equals("Exit")) {
                simpleMenu.select(sel, items);
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        SimpleMenu menu = new SimpleMenu();
        Action action = new DoAction();
        Action action1 = new NothingAction();
        MenuApplication application = new MenuApplication();
        menu.add("", "Задача 1.", action);
        menu.add("Задача 1.", "---- Задача 1.1.", action);
        menu.add("---- Задача 1.1.", "--------- Задача 1.1.1.", action);
        menu.add("---- Задача 1.1.", "--------- Задача 1.1.2.", action);
        menu.add("Задача 1.", "---- Задача 1.2.", action1);

        application.init(menu.getList(), new Scanner(System.in));
    }
}
