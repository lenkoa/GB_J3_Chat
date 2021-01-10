package lesson4.lambda;

public class Test {
    private final int VAR_X = 10;
    private final int VAR_Y = 25;
    private String name;
    private ConstVar constVar;


    public static void main(String[] args) {

        var test = new Test();
        test.testNoneVar( ()  ->  System.out.println("Hello world!") );

        test.testOneVar(var -> System.out.println("Значение аргумента: " + var));

        test.testTwoVar((varA, varB) -> {
            System.out.println("Значение аргумента 1: " + varA);
            System.out.println("Значение аргумента 2: " + varB);
        });

        Test test2 = new Test(() -> helloMessage("world"));
        test2.constVar.start();


    }

    public Test() {
    }

    public Test(ConstVar constVar) {
        this.constVar = constVar;
    }

    private static void helloMessage(String name) {
        System.out.println("Hello, " + name);
    }

    public void testNoneVar(NoneVar obj) {
        obj.start();
    }

    public void testOneVar(OneVar obj) {
        obj.start(VAR_X);
    }

    public void testTwoVar(TwoVar obj) {
        obj.start(VAR_X, VAR_Y);
    }
}
