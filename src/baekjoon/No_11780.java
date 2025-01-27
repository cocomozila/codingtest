package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_11780 {

    static List<Integer>[][] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int INF = 100_000_000;

        int[][] dist = new int[N + 1][N + 1];
        list = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                list[i][j] = new ArrayList<>();
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        list[i][j].add(k);
                        save(i, k, j);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) {
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || dist[i][j] == INF) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(list[i][j].size() + 2 + " ").append(i + " ");
                for (int a : list[i][j]) {
                    sb.append(a + " ");
                }
                sb.append(j).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void save(int i, int k, int j) {
        list[i][j].clear();
        for(int route : list[i][k]) {
            list[i][j].add(route);
        }
        list[i][j].add(k);
        for(int route : list[k][j]) {
            list[i][j].add(route);
        }
    }
}
