package ru.job4j.ood.srp;

public class TwoIntruder {

    private static TwoIntruder instance;

    private TwoIntruder() {
    }

    public static TwoIntruder getInstance() {
        if (instance == null) {
            instance = new TwoIntruder();
        }
        return instance;
    }
}
