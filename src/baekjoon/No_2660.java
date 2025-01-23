package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2660 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 100_000_000;

        int N = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int min = 999999;

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] > max) {
                    max = dist[i][j];
                }
            }
            if (min > max) {
                min = max;
                list = new ArrayList<>();
                list.add(i);
            } else if (min == max) {
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(min + " " + list.size()).append('\n');

        for (int user : list) {
            sb.append(user + " ");
        }
        System.out.println(sb.toString());
    }
}
