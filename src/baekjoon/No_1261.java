package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1261 {

    static int M, N;
    static int[][] board;
    static boolean[][] visited;
    static int[] moveX = { -1, 0, 1, 0 };
    static int[] moveY = { 0, 1, 0, -1 };
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        DP = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                DP[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0,0));
        DP[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.y][node.x]) {
                continue;
            }

            visited[node.y][node.x] = true;
            for (int i = 0; i < 4; i++) {
                int nextY = node.y + moveY[i];
                int nextX = node.x + moveX[i];
                if (valid(nextY, nextX)) {
                    if (board[nextY][nextX] == 0) {
                        if (DP[nextY][nextX] > node.cost) {
                            DP[nextY][nextX] = node.cost;
                            queue.add(new Node(node.y + moveY[i], node.x + moveX[i], node.cost));
                        }
                    } else {
                        if (DP[nextY][nextX] > node.cost + 1) {
                            DP[nextY][nextX] = node.cost + 1;
                            queue.add(new Node(node.y + moveY[i], node.x + moveX[i], node.cost + 1));
                        }
                    }
                }
            }
        }
        System.out.println(DP[N - 1][M - 1]);
    }

    private static boolean valid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M && !visited[y][x];
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
