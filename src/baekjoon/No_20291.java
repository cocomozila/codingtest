package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_20291 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine().split("\\.")[1];
            set.add(name);

            if (!map.containsKey(name)) {
                map.put(name, 1);
                continue;
            }
            map.put(name, map.get(name) + 1);
        }

        List<String> collect = new ArrayList<>(set);
        collect.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();

        for (String s : collect) {
            sb.append(s + " ").append(map.get(s)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
