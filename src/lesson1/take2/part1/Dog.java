package lesson1.take2.part1;

public class Dog extends Animal implements Run{
    public String name;

    public Dog(String name) {
        super(name);

        System.out.println(this.name);
        System.out.println(super.name);

    }

    @Override
    protected void test() {
        for (int i = 0; i < 10; i++) {

        super.test();
        }
    }



    @Override
    public void runsDistance(Distance distance) {

    }
}
