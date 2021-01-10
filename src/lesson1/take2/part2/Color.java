package lesson1.take2.part2;

public enum Color {
    BLACK("чёрный", "black"), RED("рыжий", "red"), WHITE("белый", "white");

    private String russianColor;
    private String spainColor;
    private String englishColor;

    Color(String russianColor, String englishColor) {
        this.russianColor = russianColor;
        this.englishColor = englishColor;
    }

    public String getRussianColor() {
        return russianColor;
    }

    public String getEnglishColor() {
        return englishColor;
    }

    @Override
    public String toString() {
        return "Color{" + "russianColor='" + russianColor + '\'' + ", englishColor='" + englishColor + '\'' + '}';
    }
}
