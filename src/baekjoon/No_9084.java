package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            int[] DP = new int[target + 1];
            DP[0] = 1;

            for (int j = 0; j < coins.length; j++) {
                for (int k = coins[j]; k < DP.length; k++) {
                    DP[k] = DP[k] + DP[k - coins[j]];
                }
            }

            sb.append(DP[target]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
