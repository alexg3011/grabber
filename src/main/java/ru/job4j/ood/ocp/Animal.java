package ru.job4j.ood.ocp;

public class Animal {
    private String say;

    class Cat {
        public void catSay() {
            say = "Meow";
            System.out.println(say);
        }
    }

    class Dog {
        public void dogSay() {
            say = "Gav";
            System.out.println(say);
        }
    }

}
