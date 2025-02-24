package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Integer> map = new HashMap<>();

        String wood;
        int total = 0;
        while ((wood = br.readLine()) != null) {
            total += 1;
            if (!map.containsKey(wood)) {
                map.put(wood, 1);
            } else {
                map.put(wood, map.get(wood) + 1);
            }

        }

        List<String> woods = new ArrayList<>(map.keySet());
        Collections.sort(woods);

        StringBuilder sb = new StringBuilder();
        for (String w : woods) {
            int number = map.get(w);
            double p = (double) number / total * 100;
            String pp = String.format("%.4f", p);
            sb.append(w).append(" ").append(pp).append("\n");
        }
        System.out.println(sb.toString());

    }
}
