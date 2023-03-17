package com.kodilla.abstracts;

public class Application {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.giveVoice();

        Duck duck = new Duck();
        duck.giveVoice();

        Animal dog2 = new Dog();
        dog2.giveVoice();

        AnimalProcessor processor = new AnimalProcessor();
        processor.process(dog);
    }
}
