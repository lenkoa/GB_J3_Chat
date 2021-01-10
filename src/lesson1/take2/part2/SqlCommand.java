package lesson1.take2.part2;

public enum  SqlCommand {

    UPDATE {
        @Override
        public void action() {
            System.out.println("обновление");
        }
    }, SELECT {
        @Override
        public void action() {
            System.out.println("получить выборку");
        }
    };

    public abstract void action();
}
