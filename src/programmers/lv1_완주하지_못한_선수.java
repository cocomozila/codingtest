package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lv1_완주하지_못한_선수 {

    public static void main(String[] args) {
        lv1_완주하지_못한_선수 a = new lv1_완주하지_못한_선수();
        System.out.println(a.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            if (map.containsKey(name)) {
                Integer number = map.get(name);
                if (number > 1) {
                    map.put(name, number - 1);
                } else {
                    map.remove(name);
                }
            }
        }

        Object[] array = map.keySet().toArray();
        return (String) array[0];
    }

}
