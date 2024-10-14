package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class lv2_게임_맵_최단거리 {

    static int[][] board;
    static boolean[][] check;
    static int[] moveY = {1,0,-1,0};
    static int[] moveX = {0,1,0,-1};

    public static void main(String[] args) {

    }

    public int solution(int[][] maps) {
        board = maps;
        check = new boolean[board.length][board[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == board.length - 1 && poll[1] == board[0].length - 1) {
                return poll[2];
            }

            for (int i = 0; i < 4; i++) {
                int nextY = poll[0] + moveY[i];
                int nextX = poll[1] + moveX[i];
                int count = poll[2];
                if (isValid(nextY, nextX)) {
                    check[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, count + 1});
                }
            }
        }
        return -1;
    }

    private boolean isValid(int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length && board[y][x] == 1 && !check[y][x];
    }
}
