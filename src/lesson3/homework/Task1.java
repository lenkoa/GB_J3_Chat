package lesson3.homework;

import java.util.*;
import java.util.function.BiConsumer;

public class Task1 {

    private static final String[] INPUT_DATA = {
            "a",
            "b", "b", "b",
            "c",
            "d",
            "e", "e",
            "f",
            "g", "g", "g",
            "h",
            "g",
            "i"
    };


    public static void main(String[] args) {
        Map<String, Integer> frequencyByWord = new HashMap<>();

        for (String word : INPUT_DATA) {
//            Integer frequency = frequencyByWord.get(word);
//            if (frequency == null) {
//                frequency = 0;
//            }
            Integer frequency = frequencyByWord.getOrDefault(word, 0);
            frequencyByWord.put(word, ++frequency);

        }

/*        for (Map.Entry<String, Integer> entry : frequencyByWord.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/


//        for (String key : frequencyByWord.keySet()) {
//            Integer frequency = frequencyByWord.get(key);
//            System.out.printf("%s : %d", key, frequency );
//        }

        frequencyByWord.forEach((word, frequency) -> System.out.printf("%s : %d%n", word, frequency ));


    }
}
