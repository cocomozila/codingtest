package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2169 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int[][] DP = new int[N][M];
        int[][] table;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][0] = board[0][0];
        for (int i = 1; i < M; i++) {
            DP[0][i] = board[0][i] + DP[0][i - 1];
        }

        if (N == 1) {
            System.out.println(DP[N- 1][M - 1]);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            table = new int[2][M];

            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    table[0][j] = board[i][j] + DP[i - 1][j];
                } else {
                    table[0][j] = board[i][j] + Math.max(DP[i - 1][j], table[0][j - 1]);
                }
            }

            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) {
                    table[1][j] = board[i][j] + DP[i - 1][j];
                } else {
                    table[1][j] = board[i][j] + Math.max(DP[i - 1][j], table[1][j + 1]);
                }
            }

            for (int j = 0; j < M; j++) {
                DP[i][j] = Math.max(table[0][j], table[1][j]);
            }
        }

        for (int j = 0; j < M; j++) {
            if (j == 0) {
                DP[N - 1][j] = board[N - 1][j] + DP[N - 2][j];
            } else {
                DP[N - 1][j] = board[N - 1][j] + Math.max(DP[N - 2][j], DP[N - 1][j - 1]);
            }
        }
        System.out.println(DP[N - 1][M - 1]);
    }
}
