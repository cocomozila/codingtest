package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14719 {

    static int width, height;
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        board = new int[width];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        if (isInvalidWidth(width)) {
            System.out.println(0);
            return;
        }

        int rainwater = 0;
        for (int i = 1; i < width - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(board[j], left);
            }
            for (int j = i; j < width; j++) {
                right = Math.max(board[j], right);
            }

            if (board[i] < left && board[i] < right) {
                rainwater += Math.min(left, right) - board[i];
            }
        }
        System.out.println(rainwater);

    }

    private static boolean isInvalidWidth(int width) {
        return width < 3;
    }
}
