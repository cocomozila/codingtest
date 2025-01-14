package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_14916 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] DP = new int[money + 1];

        if (money == 1 || money == 3) {
            System.out.println(-1);
            return;
        } else if (money == 2 || money == 5) {
            System.out.println(1);
            return;
        } else if (money == 4) {
            System.out.println(2);
            return;
        }

        Arrays.fill(DP, Integer.MAX_VALUE);

        DP[2] = 1;
        DP[4] = 2;
        DP[5] = 1;
        for (int i = 6; i <= money; i++) {
            DP[i] = Math.min(DP[i - 2], DP[i - 5]) + 1;
        }

        if (DP[money] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(DP[money]);
    }
}
