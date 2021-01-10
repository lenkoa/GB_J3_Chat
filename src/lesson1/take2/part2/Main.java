package lesson1.take2.part2;

import lesson1.take2.part1.Distance;
import lesson1.take2.part1.Run;

public class Main {

    public static void main(String[] args)  {
        Dog dog = new Dog(Color.RED);
/*        dog.print();

        switch (dog.color) {
            case WHITE -> System.out.println("налево");
            default -> System.out.println("направо");
        }

        if (dog.color == Color.WHITE) {
            System.out.println("собака белая");
        }

        SqlCommand.SELECT.action();*/

//        Dog.DogAttribute dogAttribute = dog.new DogAttribute("Тузик", 4);
//        Dog.DogAttribute dogAttribute = new Dog.DogAttribute("Тузик", 4);

        Dog dog1 = new Dog(Color.BLACK) {
            @Override
            public String toString() {
                return "toString()";
            }
        } ;

        Run runner = new Run() {
            @Override
            public void runsDistance(Distance distance) {
                System.out.println("Бежать!");
            }

            @Override
            public void run() {
                class A {

                }
                System.out.println("Бежать!");

            }
        };

        runner.run();

    }
}
