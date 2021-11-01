package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartMenu {
    private static List<Item> listMenu = new ArrayList<>();

    public void init(Scanner scanner) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select: ");
            String select = scanner.nextLine();

            if (!select.equals("Exit")) {
                PrintItem printItem = new PrintItem(select);
                printItem.printAction(listMenu);
            } else {
                System.out.println("Good bye!");
                run = false;
            }
        }
    }

    private void showMenu() {
        ShowMenu menu = new ShowMenu();
        menu.showMenu(listMenu);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Action action1 = new Print();
        Action action2 = new PrintTwo();

        Item itemTask111 = new Item("Задача 1.1.1", new ArrayList<>(), action1);
        Item itemTask112 = new Item("Задача 1.1.2", new ArrayList<>(), action1);
        Item itemTask11 = new Item("Задача 1.1", List.of(itemTask111, itemTask112), action1);
        Item itemTask12 = new Item("Задача 1.2", new ArrayList<>(), action1);
        Item itemTask1 = new Item("Задача 1.", List.of(itemTask11, itemTask12), action1);
        Item itemExit = new Item("Exit", new ArrayList<>(), action2);
        listMenu.add(itemTask1);
        listMenu.add(itemExit);
        StartMenu startMenu = new StartMenu();
        startMenu.init(input);

    }
}
