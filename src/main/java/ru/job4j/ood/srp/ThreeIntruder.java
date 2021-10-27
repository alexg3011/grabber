package ru.job4j.ood.srp;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ThreeIntruder {

    public void printDate() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(Date.from(
                date.atZone(ZoneId.systemDefault()).toInstant()));
    }
}
