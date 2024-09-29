package programmers;

import java.util.*;

public class lv2_의상 {

    static ArrayList<Integer> list;
    static int answer = 1;

    public static void main(String[] args) {
        lv2_의상 c = new lv2_의상();
        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("답 : " + c.solution(arr));
        answer = 0;
        String[][] arr2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println("답 : " + c.solution(arr2));
        answer = 0;
        String[][] arr3 = {{"crow_mask", "face1"}, {"blue_sunglasses", "face2"}, {"smoky_makeup", "face3"}};
        System.out.println("답 : " + c.solution(arr3));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> categoryMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            if (categoryMap.containsKey(category)) {
                categoryMap.put(category, categoryMap.get(category) + 1);
            } else {
                categoryMap.put(category, 1);
            }
        }
        list = new ArrayList<>(categoryMap.values());
        if (list.size() == 1) {
            return clothes.length;
        }

        for (int i = 0; i < list.size(); i++) {
            answer *= (list.get(i) + 1);
        }

        return answer - 1;
    }

}
