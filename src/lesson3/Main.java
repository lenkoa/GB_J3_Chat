package lesson3;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;

public class Main {


    public static void main(String[] args) {
//        testArrayList();
//        testLinkedList();
//        testSet();
        testMap();
    }

    private static void testMap() {
        Map<String, String> map = new HashMap<>();

        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");



/*        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", entry.getKey(), entry.getValue()));
        }*/

/*        for (String s : map.keySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", s, map.get(s)));
        }*/

        map.forEach((key, value) -> System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", key, value)));

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", key, value));
            }
        });


    }

    private static void testSet() {

        Set<String> set = new TreeSet<>();
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("A");
        set.add("F");
        set.add("B");
        set.add("B");
        set.add("F");
        set.add("G");

        System.out.println(set);
    }

    private static void testLinkedList() {

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("F");

        linkedList.set(1, "Q");

        Collections.sort(linkedList);

        System.out.println(linkedList.get(55));

        System.out.println(linkedList);
    }

    private static void testArrayList() {

        ArrayList<HashSet> al = new ArrayList<>();

//        ArrayList<String> arrayList = new ArrayList<>();
        var arrayList = new ArrayList<String>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.remove("B");

        arrayList.add(0, "D");

        arrayList.trimToSize();

        System.out.println(arrayList);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }

        for (String s : arrayList) {
            System.out.println(s);
        }

    }
}
