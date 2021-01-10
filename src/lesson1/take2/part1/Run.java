package lesson1.take2.part1;

public interface Run {

    default void run() {
        System.out.println("Интерфейс бежит");
    }
    void runsDistance(Distance distance);

    default void test2() {
        System.out.println("Fly");
    }
}
