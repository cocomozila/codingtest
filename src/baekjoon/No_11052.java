package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] packs = new int[N];

        for (int i = 0; i < N; i++) {
            packs[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N + 1];

        for (int i = 1; i <= packs.length; i++) {
            DP[i] = packs[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                DP[i] = Math.max(DP[i], DP[i - j] + DP[j]);
            }
        }

        System.out.println(DP[N]);
    }
}
