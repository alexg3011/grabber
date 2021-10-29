package ru.job4j.ood.isp;

/* Интерфейс нарушает принцип isp, тк у животных,
 которые не умеют что-то из перечисленного придется глушить этот метод */

public interface Animal {
    void run();

    void fly();
}
