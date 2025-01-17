package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] DP = new int[4][10001];
        DP[1][1] = 1;
        DP[1][2] = 1;
        DP[1][3] = 1;
        DP[2][2] = 1;
        DP[2][3] = 1;
        DP[3][3] = 1;
        for (int i = 4; i < 10001; i++) {
            DP[1][i] = DP[1][i - 1];
            DP[2][i] = DP[1][i - 2] + DP[2][i - 2];
            DP[3][i] = DP[1][i - 3] + DP[2][i - 3] + DP[3][i - 3];
        }

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(DP[1][num] + DP[2][num] + DP[3][num]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
