package lesson2;

public class CatOffException extends Exception {

    public CatOffException() {
        super("Котам здесь не рады!");

    }

    public CatOffException(int n) {
        super("Засланец затаился под номером " + n);
    }
}
