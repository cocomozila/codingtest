package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3085 {

    static int N;
    static String[][] board;
    static int[] moveX = {-1, 0};
    static int[] moveY = {0, -1};
    static int answer = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < string.length(); j++) {
                board[i][j] = string.substring(j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findAnswer(i, j);
            }
        }
        System.out.println(answer);
    }

    public static void findAnswer(int y, int x) {
        for (int i = 0; i < 2; i++) {
            if (isValid(y + moveY[i], x + moveX[i])) {
                run(y, x, y + moveY[i], x + moveX[i]);
            }
        }
    }

    public static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0;
    }

    public static void run(int y1, int x1, int y2, int x2) {
        changeBoard(y1, x1, y2, x2);
        int max1, max2, max3;

        if (isVertical(y2, y1)) {
            max1 = verticalCount(x1);
            max2 = horizontalCount(y1);
            max3 = horizontalCount(y2);
        } else {
            max1 = verticalCount(x1);
            max2 = verticalCount(x2);
            max3 = horizontalCount(y1);
        }
        answer = Math.max(answer, Math.max(max1, Math.max(max2, max3)));
        rollbackBoard(y1, x1, y2, x2);
    }

    public static void changeBoard(int y1, int x1, int y2, int x2) {
        String changeWord = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = changeWord;
    }

    public static void rollbackBoard(int y1, int x1, int y2, int x2) {
        String changeWord = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = changeWord;
    }

    public static int verticalCount(int x) {
        int maxCount = 1;
        int count = 1;
        String baseWord = board[0][x];
        for (int i = 1; i < N; i++) {
            String word = board[i][x];
            if (baseWord.equals(word)) {
                count = count + 1;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
                baseWord = word;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static int horizontalCount(int y) {
        int maxCount = 1;
        int count = 1;
        String baseWord = board[y][0];
        for (int i = 1; i < N; i++) {
            String word = board[y][i];
            if (baseWord.equals(word)) {
                count = count + 1;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
                baseWord = word;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static boolean isVertical(int y2, int y1) {
        return y1 - y2 > 0;
    }
}
