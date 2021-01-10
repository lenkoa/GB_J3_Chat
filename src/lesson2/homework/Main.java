package lesson2.homework;

public class Main {
    public static final int SIZE = 4;
    private static String[][] strings = new String[SIZE][SIZE];

    public static void main(String[] args) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] = String.valueOf(i * j);
            }
        }
//        strings[2][3] = "Hello!";
        int sum = 0;

        try {
            sum = calculateSum(strings);
            System.out.println("Сумма все элементов: " + sum);
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private static int calculateSum(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strings[0].length != SIZE || strings.length != SIZE){
            throw new MyArraySizeException("Размер массива не [4][4]");
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {

                try{
                    sum += Integer.parseInt(strings[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(j, i);
                }
            }
        }

        return sum;
    }

}