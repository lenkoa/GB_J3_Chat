package lesson1.take1.part1;

public class B extends A implements IOne, ITwo {

    public void test() {

    }

    @Override
    public int mathSum() {
        return 0;
    }

    @Override
    public void doMethod() {
        System.out.println("Метод в Б");
    }

}
