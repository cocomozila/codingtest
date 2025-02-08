package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int max = 0;
        for (int i = 1; i < list.size() + 1; i++) {
            int rope = list.get(i - 1);
            if (i == 1) {
                max = rope;
            }
            if (max < rope * i) {
                max = rope * i;
            }
        }

        System.out.println(max);
    }
}
