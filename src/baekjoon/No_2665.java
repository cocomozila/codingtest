package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2665 {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] moveY = {1, 0, -1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];
        DP = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                DP[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        DP[0][0] = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            int y = node.y;
            int x = node.x;
            int cost = node.cost;

            if (visited[y][x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + moveY[i];
                int nextX = x + moveX[i];

                if (isValid(nextY, nextX)) {
                    if (board[nextY][nextX] == 0) {
                        if (DP[nextY][nextX] > cost + 1) {
                            DP[nextY][nextX] = cost + 1;
                            queue.addLast(new Node(nextY, nextX, cost + 1));
                        }
                    } else {
                        if (DP[nextY][nextX] > cost) {
                            DP[nextY][nextX] = cost;
                            queue.addFirst(new Node(nextY, nextX, cost));
                        }
                    }
                }
            }

        }
        System.out.println(DP[N - 1][N - 1]);
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N && !visited[y][x];
    }

    static class Node {
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
