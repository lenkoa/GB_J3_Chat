package lesson5;

public class Foo {

    private final int STEPS = 10;
    public static final int DELAY = 500;

    private Object lock = "new Object()";

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> foo.methodA()).start();
        new Thread(() -> foo.methodA()).start();
        new Thread(() -> foo.methodB()).start();
        new Thread(() -> foo.methodB()).start();
    }

    public void methodA() {
        synchronized (lock) {
            System.out.println("Start A");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End A");
        }
    }


    public void methodB() {
        synchronized (lock) {
            System.out.println("Start B");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End B");
        }
    }
}
