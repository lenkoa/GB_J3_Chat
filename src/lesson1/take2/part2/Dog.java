package lesson1.take2.part2;

public class Dog {

    private Color color;
    private DogAttribute dogAttribute;

    public Dog(Color color) {
        this.color = color;
//        dogAttribute = new DogAttribute("Тузик", 4);

//        Божественный объект
    }

    class DogAttribute {
        public String name;
        private int age;


        public DogAttribute(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "DogAttribute{" + "name='" + name + '\'' + ", age=" + age + '}' + color;
        }
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dog{" + "color='" + color + '\'' + '}' + dogAttribute.age;
    }
}
