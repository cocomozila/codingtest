package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_17182 {

    static int N, K, answer;
    static boolean[] visited;
    static int[][] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int INF = 100_000_000;
        answer = INF;

        dist = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        visited[K] = true;
        DFS(1, K, 0);
        System.out.println(answer);
    }

    private static void DFS(int depth, int start, int sum) {
        if (depth == N) {
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == start) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, i, sum + dist[start][i]);
                visited[i] = false;
            }
        }
    }
}
