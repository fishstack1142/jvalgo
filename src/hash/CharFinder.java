package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public static void main(String[] args) {
//        CharFinder charFinder =  new CharFinder();
//        char ch = charFinder.findFirstNonRepeatingChar("a green a apple");
//        System.out.println(ch);

        CharFinder finder = new CharFinder();
        char ch2 = finder.findFirstRepeatedChar("green apple");
        System.out.println(ch2);

    }


    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        for (char ch : chars) {
//            if() {
//                int count = map.get(ch);
//                map.put(ch, count);
//
//                int count = map.containsKey(ch) ? map.get(ch) : 0;
//                map.put(ch, count + 1);
//            }
//            else
//                map.put(ch, 1);
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        System.out.println(map);
        for (char ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
