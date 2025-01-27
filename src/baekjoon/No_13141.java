package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_13141 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = 100_000_000;

        double[][] dist = new double[N + 1][N + 1];
        List<int[]> list = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
                dist[b][a] = c;
            }

            list.add(new int[]{a, b, c});
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // i번째 줄의 (dist[v][a] + dist[v][b] + (a, b 사이의 걸리는 시간)) / 2 의 최대값 中 최소값을 찾으면 됨.

        double minValue = INF;

        for (int i = 1; i <= N; i++) {
            double iMaxValue = 0;

            for (int[] arr : list) {
                int a = arr[0];
                int b = arr[1];
                int c = arr[2];

                double time = (dist[i][a] + dist[i][b] + c) / 2;
                iMaxValue = Math.max(iMaxValue, time);
            }

            minValue = Math.min(minValue, iMaxValue);
        }

        System.out.printf("%.1f\n", minValue);

    }
}
