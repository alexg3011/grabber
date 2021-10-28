package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportJson implements Report {

    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson json = new GsonBuilder().create();
        return json.toJson(store.findBy(filter));
    }
}
