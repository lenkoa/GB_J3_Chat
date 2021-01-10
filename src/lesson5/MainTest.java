package lesson5;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t;

        t = Thread.currentThread();
        System.out.println(t);
        t.setName("Новое имя");
        t.setPriority(10);
        System.out.println("Ждем...");
        Thread.sleep(5000);
        System.out.println(t);

    }

}
