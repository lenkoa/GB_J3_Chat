package lesson5;

public class TestSync {

    private static final int STEPS = 10000;
    private int counter;

    public static void main(String[] args) {

        TestSync testSync= new TestSync();

        var t1 = new Thread(() -> testSync.incCounter());
        var t2 = new Thread(() -> testSync.decCounter());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(testSync.counter);
    }

    public synchronized void incCounter() {
        for (int i = 0; i < STEPS; i++) {
            counter++;
        }
    }

    public synchronized void decCounter() {
        for (int i = 0; i < STEPS; i++) {
            counter--;
        }
    }
}
