package programmers;

public class lv3_등굣길 {

    static int[][] board;
    static int[][] DP;

    public int solution(int m, int n, int[][] puddles) {

        board = new int[n][m];
        DP = new int[n][m];

        for (int[] num : puddles) {
            board[num[1] - 1][num[0] - 1] = -1;
        }

        DP[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || board[i][j] == -1) continue;
                if (i == 0) {
                    if (board[i][j - 1] != -1) {
                        DP[i][j] = DP[i][j - 1];
                    }
                } else if (j == 0) {
                    if (board[i - 1][j] != -1) {
                        DP[i][j] = DP[i - 1][j];
                    }
                } else {
                    if (board[i - 1][j] == -1) {
                        DP[i][j] = DP[i][j - 1];

                    } else if (board[i][j - 1] == -1) {
                        DP[i][j] = DP[i - 1][j];
                    } else {
                        if (DP[i][j - 1] + DP[i - 1][j] > 1_000_000_007) {
                            DP[i][j] = (DP[i][j - 1] + DP[i - 1][j]) % 1_000_000_007;
                        } else {
                            DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
                        }
                    }
                }
            }
        }
        return DP[n - 1][m - 1] % 1_000_000_007;
    }
}
