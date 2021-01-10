package lesson1.take1.part2;

public class Main {

    public static void main(String[] args) {
        SqlCommand command = SqlCommand.UPDATE;

        //.......

        command.action();

        Cat cat = new Cat();
        cat.testAnon();
        Cat cat2 = new Cat_TWO();
        cat2.testAnon();
        Cat cat3 = new Cat() {
/*
            static public void testStatic() {

            }*/


            @Override
            public void testAnon() {
                System.out.println("Привет от кота-анонимуса");
            }
        };
        cat3.testAnon();

//        cat2.bar();

    }
}
