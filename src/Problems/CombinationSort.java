package Problems;

import java.util.*;

public class CombinationSort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77");

        System.out.println("L1 : " + sortWithCharacter(list));
        System.out.println("L2 : " + sortWithCharacterAndNumber(list));
    }

    public static List<String> sortWithCharacter(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.charAt(0) - s2.charAt(0);
            }
        });

        return list;
    }

    public static List<String> sortWithCharacterAndNumber(List<String> list) {
        Map<Character, PriorityQueue<String>> map = new HashMap<>();

        for (String str : list) {
            map.putIfAbsent(str.charAt(0), new PriorityQueue<>((a, b) ->
                    Integer.parseInt(a.substring(1)) - Integer.parseInt(b.substring(1))));
            map.get(str.charAt(0)).offer(str);
        }

        List<String> res = new ArrayList<>();

        for (char i = 'a'; i < 'z'; i++) {
            if(map.containsKey(i)) {
                List<String> temp = new ArrayList<>(map.get(i).stream().toList());
                Collections.reverse(temp);
                res.addAll(temp);
            }
        }

        return res;
    }
}
