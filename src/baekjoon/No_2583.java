package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_2583 {

    static int N, M, K;
    static boolean[][] board;
    static boolean[][] check;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int tileCount = 0;
    static int answer = 0;
    static int blockCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    board[k][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j);
                if (tileCount > 0) {
                    blockCount += 1;
                    queue.add(tileCount);
                    tileCount = 0;
                }
            }
        }

        sb.append(blockCount).append("\n");
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void DFS(int y, int x) {
        if (isValid(y, x) && isNotVisited(y, x)) {
            board[y][x] = true;
            for (int i = 0; i < 4; i++) {
                DFS(y + moveX[i], x + moveY[i]);
            }
            tileCount += 1;
        }
    }

    public static boolean isNotVisited(int y, int x) {
        return !board[y][x];
    }

    public static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
