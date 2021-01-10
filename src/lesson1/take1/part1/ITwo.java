package lesson1.take1.part1;

public interface ITwo {
   default void doMethod() {
        System.out.println("Борис");
    }

    default void foo() {
        System.out.println("World!");
    }
}
