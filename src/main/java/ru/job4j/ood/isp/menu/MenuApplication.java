package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class MenuApplication {

    private void init(Scanner scanner, Menu menu, String itemName) {
        boolean run = true;
        while (run) {
            System.out.println("Select: ");
            System.out.println(itemName);
            String select = scanner.nextLine();
            if (!select.equals("Exit")) {
                Action action = menu.select(select);
                if (action != null) {
                    action.action();
                } else {
                    System.out.println("Действие не найдено!");
                }
            } else {
                menu.select(select).action();
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        SubMenuPrinter console = new ConsoleSubMenuPrinter();
        menu.add("", "Задача 1.", new NothingAction());
        menu.add("Задача 1.", "Задача 1.1.", new DoAction());
        menu.add("Задача 1.1.", "Задача 1.1.1.", new DoAction());
        menu.add("Задача 1.1.", "Задача 1.1.2.", new DoAction());
        menu.add("Задача 1.", "Задача 1.2.", new DoAction());
        menu.add("", "Exit", new NothingAction());
        MenuApplication app = new MenuApplication();
        Scanner scanner = new Scanner(System.in);
        app.init(scanner, menu, console.toString(menu.getItems()));
    }
}
