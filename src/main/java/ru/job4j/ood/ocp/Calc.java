package ru.job4j.ood.ocp;

/* Нарушение ocp, тк для каждой функции придется писать свой метод */
public class Calc {
    public int sum(int a, int b) {
        return a + b;
    }

    public int diff(int a, int b) {
        return a - b;
    }
}
