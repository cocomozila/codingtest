package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10159 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        int INF = 100_000_000;

        int[][] dist = new int[N + 1][N + 1];
        int[][] distRev = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
                distRev[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            distRev[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    distRev[i][j] = Math.min(distRev[i][j], distRev[i][k] + distRev[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int count = N - 1;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] != INF || distRev[i][j] != INF) {
                    count -= 1;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
