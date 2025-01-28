package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_21940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        int INF = 100_000_000;

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
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] friends = new int[K];

        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        int minDist = Integer.MAX_VALUE;
        List<Integer> city = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int distSum = 0;

            for (int j = 0; j < K; j++) {
                distSum = Math.max(distSum, dist[i][friends[j]] + dist[friends[j]][i]);
            }

            if (minDist > distSum) {
                minDist = distSum;
                city = new ArrayList<>();
                city.add(i);
            } else if (minDist == distSum) {
                city.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < city.size(); i++) {
            sb.append(city.get(i) + " ");
        }

        System.out.println(sb.toString());
    }
}
