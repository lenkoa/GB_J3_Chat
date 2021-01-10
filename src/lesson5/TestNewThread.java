package lesson5;

public class TestNewThread {

    public static void main(String[] args) {

//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);

            }
        }, "B");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);

            }
        }, "C").start();

        t1.setPriority(1);
        t2.setPriority(1);

        t1.start();
        t2.start();

    }
}
