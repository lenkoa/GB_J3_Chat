package lesson1.take1.part1;

public interface IOne {

    /*public static final */ String str = "Hello";

    int mathSum();

     default void doMethod() {
         System.out.println("Hello");
     }
}
