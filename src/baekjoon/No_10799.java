package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pipe = br.readLine().toCharArray();
        char left = '(';

        int count = 0;
        int total = 0;
        for (int i = 0; i < pipe.length; i++) {
            char now = pipe[i];

            if (now == left) {
                count += 1;
                continue;
            }
            if (i > 0) {
                char before = pipe[i - 1];
                if (before == left) {
                    count -= 1;
                    total += count;
                    continue;
                }
                count -= 1;
                total += 1;
            }
        }
        System.out.println(total);
    }
}
