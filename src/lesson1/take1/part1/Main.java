package lesson1.take1.part1;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

/*        A[] arr = {a, b};

        for (A a1 : arr) {
            if (a1 instanceof A)
            ((B)a1).test();
        }*/

        b.doMethod();
        b.foo();
//        System.out.println(B.str);
    }
}
