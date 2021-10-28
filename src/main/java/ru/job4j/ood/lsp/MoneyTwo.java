package ru.job4j.ood.lsp;

public class MoneyTwo {
    public int sendMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Отрицательная сумма");
        }
        return money;
    }

    static class DepositMoney extends Money {

        @Override
        public int sendMoney(int money) {
            return money;
        }
    }
}
