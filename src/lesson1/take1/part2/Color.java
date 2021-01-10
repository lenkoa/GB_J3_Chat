package lesson1.take1.part2;

public enum Color {

    ORANGE("рыжий"), BLACK("черный"), WHITE("белый");

    private String russianColor;

    Color(String russianColor) {
        this.russianColor = russianColor;
    }

    public String getRussianColor() {
        return russianColor;
    }

    @Override
    public String toString() {
        return "Color:" + "russianColor='" + russianColor + " " + name();
    }



}
