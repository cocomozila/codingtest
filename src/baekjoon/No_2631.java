package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2631 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        int[] DP = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (children[i] > children[j] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                    max = Math.max(max, DP[i]);
                }
            }
        }

        System.out.println(N - max);
    }
}
