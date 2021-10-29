package ru.job4j.ood.ocp;

/* Нарушение принципа открытости-закрытости,
тк для каждого животного надо переопределять метод say() */
public class Animal {
    public void say() {
    }

    static class Cat extends Animal {
        @Override
        public void say() {
            String say = "Meow";
            System.out.println(say);
        }
    }

    static class Dog extends Animal {
        @Override
        public void say() {
            String say = "Gav";
            System.out.println(say);
        }
    }

}
