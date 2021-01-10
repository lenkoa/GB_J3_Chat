package lesson1.take2.part1;

public class Duck extends Animal implements Fly, Run{

    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("утка");
    }

    @Override
    public void test2() {

    }

    public void voice() {
        System.out.println("кря");
    }



    @Override
    public void runsDistance(Distance distance) {

    }
}
