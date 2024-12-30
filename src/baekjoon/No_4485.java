package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_4485 {

    static int N = 1;
    static int[][] board;
    static int[] moveY = {1, 0, -1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static int[][] DP;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int index = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            DP = new int[N][N];
            board = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    DP[i][j] = Integer.MAX_VALUE - 1;
                }
            }

            Queue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(0, 0, board[0][0]));
            DP[0][0] = board[0][0];

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int y = node.y;
                int x = node.x;
                int cost = node.cost;

                if (visited[y][x]) {
                    continue;
                }

                visited[y][x] = true;

                for (int i = 0; i < 4; i++) {
                    int nextY = y + moveY[i];
                    int nextX = x + moveX[i];

                    if (valid(nextY, nextX)) {
                        if (DP[nextY][nextX] > node.cost + board[nextY][nextX]) {
                            DP[nextY][nextX] = node.cost + board[nextY][nextX];
                            queue.add(new Node(nextY, nextX, DP[nextY][nextX]));
                        }
                    }
                }
            }
            sb.append("Problem ").append(index++).append(": ").append(DP[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean valid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N && !visited[y][x];
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
