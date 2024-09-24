package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No_2468 {

    static int[][] borad;
    static Set<Integer> set = new HashSet<>();
    static boolean[][] check;
    static int N;
    static int[] moveY = {0, -1, 0, 1};
    static int[] moveX = {1, 0, -1, 0};
    static int answer = 1;
    static int count = 0;


    public static void main(String[] args) throws IOException {

        init();

        for (int n : set) {
            check = new boolean[N][N];
            int saveArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    DFS(i, j, n);
                    if (count > 0) {
                        saveArea += 1;
                        count = 0;
                    }
                }
            }
            answer = Math.max(saveArea, answer);
        }
        System.out.println(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        borad = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                set.add(number);
                borad[i][j] = number;
            }
        }
    }

    public static void DFS(int y, int x, int target) {
        if (isValid(y, x) && isNotVisited(y, x) && borad[y][x] > target) {
            check[y][x] = true;
            for (int i = 0; i < 4; i ++) {
                DFS(y + moveY[i], x + moveX[i], target);
            }
            count += 1;
        }
    }

    public static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    public static boolean isNotVisited(int y, int x) {
        return !check[y][x];
    }
}
