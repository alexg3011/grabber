package ru.job4j.ood.ocp;

public class Client {

    public void sendHello() {
        System.out.println("Hello");
    }
}

class Server extends Client {

    @Override
    public void sendHello() {
        System.out.println("Hi");
    }
}
