package ru.job4j.ood.isp.menu;

public class NothingAction implements Action {
    @Override
    public void action() {
        System.out.println("Nothing");
    }
}
