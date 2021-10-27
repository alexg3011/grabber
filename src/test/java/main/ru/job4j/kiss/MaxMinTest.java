package main.ru.job4j.kiss;

import org.junit.Test;
import ru.job4j.kiss.MaxMin;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MaxMinTest {
    @Test
    public void whenFindMax() {
        List<Integer> list = Arrays.asList(3, 1, 4, -1, 5, 4);
        MaxMin max = new MaxMin();
        assertThat(5, is(max.max(list, Integer::compareTo)));
    }

    @Test
    public void whenFindMin() {
        List<Integer> list = Arrays.asList(3, 1, 4, -1, 5, 4);
        MaxMin min = new MaxMin();
        assertThat(-1, is(min.min(list, Integer::compareTo)));
    }

    @Test
    public void whenAllNumbersEqualsFindMax() {
        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 1);
        MaxMin max = new MaxMin();
        assertThat(1, is(max.max(list, Integer::compareTo)));
    }

    @Test
    public void whenAllNumbersEqualsFindMin() {
        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 1);
        MaxMin min = new MaxMin();
        assertThat(1, is(min.min(list, Integer::compareTo)));
    }
}
