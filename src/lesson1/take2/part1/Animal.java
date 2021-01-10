package lesson1.take2.part1;

public abstract class Animal {
    public String name;
    public static int countDogs;

    public Animal(String name) {
        this.name = name;
    }

    protected void test() {
        System.out.println("Метод из животного");
    }

}
