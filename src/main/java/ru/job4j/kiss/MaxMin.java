package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = x -> x > 0;
        return compare(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = x -> x < 0;
        return compare(value, comparator, predicate);
    }

    private <T> T compare(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T val = value.get(0);
        for (T t : value) {
            if (predicate.test(comparator.compare(t, val))) {
                val = t;
            }
        }
        return val;
    }
}