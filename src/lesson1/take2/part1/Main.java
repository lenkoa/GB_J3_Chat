package lesson1.take2.part1;

import lesson1.take1.part1.A;

public class Main {

    public static void main(String[] args) {

//        Dog dog = new Dog("Собака");
/*        dog.test();
//        dog.countDogs = 6;
        System.out.println(Animal.countDogs);

        Integer intValue = 4;
        Integer otherValue = intValue;
        otherValue++;
        System.out.println("intValue" + intValue);*/

//        Animal animal = new Animal();
        Duck duck = new Duck("Donald");
        Airbus airbus = new Airbus();
        Fly[] flies = {duck, airbus};

       /* for (Fly flyObject : flies) {
           flyObject.fly();
           if (flyObject instanceof Duck)
            ((Duck)flyObject).voice();
        }*/

        duck.run();
        new Dog("name").run();
    }
}
