package lesson1.take1.part2;

public class Cat {

    private Color color = Color.BLACK;

    public Cat() {
        CatAttribute catAttribute = new CatAttribute("Борис Николаевич", 1);

        catAttribute.printAttributes();
    }

    static class CatTestInnerStatic {

    }

    class CatAttribute {
        public String name;
        private int age;

        public CatAttribute(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void printAttributes() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "CatAttribute{" + "name='" + name + '\'' + ", age=" + age + '}' + " color: " + color.getRussianColor();
        }
    }


    public static void main(String[] args) {

//        new Cat();
        Cat cat = new Cat();
        CatAttribute catAttribute = cat.new CatAttribute("Мартин", 2);
        catAttribute.printAttributes();
        Cat.CatTestInnerStatic catTestInnerStatic = new Cat.CatTestInnerStatic();

    }

    public void testAnon() {
        System.out.println("Привет от кота!");
    }

    public void test() {

        if (color == Color.BLACK) {}

        switch (color) {
            case BLACK:
                System.out.println("цвет нашей кошки: " + color.getRussianColor());
            case ORANGE:
        }
    }

}
