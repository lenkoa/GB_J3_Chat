package lesson1.take2.part1;

public class Airbus implements Fly {

    @Override
    public void fly() {
        System.out.println("самолет");
    }



    public void voice() {
        System.out.println("кря");
    }
}
