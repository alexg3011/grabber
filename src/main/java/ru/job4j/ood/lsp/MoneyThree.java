package ru.job4j.ood.lsp;

public class MoneyThree {
    public int sendMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Отрицательная сумма");
        } else if (money > 1000) {
            throw new IllegalArgumentException("Слишком большая сумма");
        }
        return money;
    }

    static class Dollar extends Money {

        @Override
        public int sendMoney(int money) {
            if (money > 0) {
                throw new IllegalArgumentException("Отрицательная сумма");
            }
            return money;
        }
    }
}
