package lesson2;

import lesson1.take2.part1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*System.out.println(foo());

        try {
            readFile("/123.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

//        System.out.println(returnInt(10, 0));


//        runAnimal();

        try {
            runAnimal2();
        } catch (CatOffException e) {
            System.out.println("Хватит это терпеть!");
            e.printStackTrace();
        }

    }

    private static String foo() {

        int[] arr = {5, 5, 5, 5, 5, 5};
        int[] arrDivider = {1, 2, 3, 4, 0, 5, 6, 7, 0, 8, 10};

        doArifmetic(arr, arrDivider);

        return Arrays.toString(arr);

    }

    private static void doArifmetic(int[] arr, int[] arrDivider) {

        for (int i = 0; i < arrDivider.length; i++) {

            try {
                arr[i] /= arrDivider[i];
//                throw new ArrayIndexOutOfBoundsException();
//                System.out.println("11111");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Реакция!");
            } catch (ArithmeticException e) {
                arr[i] = 0;
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
    }

    private static void readFile2(String path) {

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    private static int returnInt(int a, int b) {

        try {
            return a / b;
        } catch (ArithmeticException e) {
            return a;
        } finally {
            return -1;
        }

    }

    private static void runAnimal() {
        Run[] animals = {new Dog("Барсик"), new Cat("Борис Николаевич"), new Duck("Инокентий")};

        try {
            for (Run animal : animals) {

                if (animal instanceof Cat) {
                    throw new CatOffException();
                }
                animal.run();

            }
        } catch (CatOffException e) {
            System.out.println("Очень жаль, так все хорошо начиналось");
            e.printStackTrace();
        }

    }

    private static void runAnimal2() throws CatOffException {
        Run[] animals = {new Dog("Барсик"), new Cat("Борис Николаевич"), new Duck("Инокентий")};

        for (Run animal : animals) {

            if (animal instanceof Cat) {
                throw new CatOffException();
            }
            animal.run();

        }


    }

}
