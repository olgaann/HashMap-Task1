import java.util.*;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) { //перебираем все символы строки text
            char key = Character.toLowerCase(text.charAt(i)); //приводим символ к нижнему регистру
            if (Character.isLetter(key)) { //нас интересуют только буквы, не знаки и пробелы
                if (map.containsKey(key)) { //если символ уже встречался,
                    int value = map.get(key);
                    value++; //увеличим число повторений на единицу
                    map.put(key, value);
                } else {  //если встречается впервые,
                    map.put(key, 1); //запишем в map одно повторение
                }
            }
        }

        System.out.println(map); //выведем получившуюся мапу на экран
        int maxValue = max(map); //сколько раз встречается самый частый символ(символы)
        int minValue = min(map); //сколько раз встречается самый редкий символ(символы)

        System.out.println("Самые часто- и редковстречающиеся символы:");
        for (Map.Entry<Character, Integer> pair : map.entrySet()) { //перебираем пары
            if (pair.getValue() == maxValue) {
                System.out.println(pair.getKey() + " => " + pair.getValue() + "шт.");
            } else if (pair.getValue() == minValue) {
                System.out.println(pair.getKey() + " => " + pair.getValue() + "шт");
            }
        }

    }

    public static int max(Map<Character, Integer> map) { //метод возвращает максимальное число вхождений символа(или нескольких)
        int maxValue = 0;
        for (char k : map.keySet()) {
            int value = map.get(k);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static int min(Map<Character, Integer> map) { //метод возвращает минимальное число вхождений символа(или нескольких)
        int minValue = Integer.MAX_VALUE;
        for (char k : map.keySet()) {
            int value = map.get(k);
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }


}
