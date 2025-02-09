package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] money = {25, 10, 5, 1};

        for (int i = 0; i < T; i++) {
            int[] ar = new int[money.length];
            int n = Integer.parseInt(br.readLine());

            int index = 0;
            while (n != 0) {
                if (n - money[index] >= 0) {
                    n -= money[index];
                    ar[index] += 1;
                } else {
                    index += 1;
                }
            }

            sb.append(ar[0] + " " + ar[1] + " " + ar[2] + " " + ar[3] + "\n");
        }
        System.out.println(sb.toString());
    }
}
