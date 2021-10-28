package ru.job4j.ood.lsp;

import java.util.Date;

public class Cheese extends Food {
    public Cheese(String name, Date expiryDate, Date createDate, int price, boolean discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
