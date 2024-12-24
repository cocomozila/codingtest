package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2178 {

    static int[][] board;
    static boolean[][] check;
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;

            if (y == N - 1 && x == M - 1) {
                System.out.println(node.count);
                return;
            }

            if (check[y][x]) {
                continue;
            }

            check[y][x] = true;

            for (int i = 0; i < 4; i++) {
                if (isValid(y + moveY[i], x + moveX[i])) {
                    queue.add(new Node(y + moveY[i], x + moveX[i], node.count + 1));
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < board.length && x < board[y].length && board[y][x] == 1;
    }

    static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
