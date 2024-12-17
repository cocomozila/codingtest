package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1504 {

    static int[][] dist;
    static int N, E;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int defaultValue = 80_000_000;

        dist = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = defaultValue;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        floyd();

        int answer = Math.min(dist[1][M] + dist[M][K] + dist[K][N], dist[1][K] + dist[K][M] + dist[M][N]);
        if (answer >= defaultValue) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void floyd() {
        // 경유지
        for (int i = 1; i <= N; i++) {

            // 출발지
            for (int j = 1; j <= N; j++) {

                // 도착지
                for (int k = 1; k <= N; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
    }
}
