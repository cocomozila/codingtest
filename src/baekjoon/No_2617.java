package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2617 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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

        for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             dist[a][b] = 1;
             distRev[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                    if (distRev[i][j] > distRev[i][k] + distRev[k][j]) {
                        distRev[i][j] = distRev[i][k] + distRev[k][j];
                    }
                }
            }
        }

        int answer = 0;
        int middlePoint = (N + 1) / 2;
        for (int i = 1; i <= N; i++) {
            int heavierCount = 0;
            int lighterCount = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] != INF) {
                    lighterCount += 1;
                }
                if (distRev[i][j] != INF) {
                    heavierCount += 1;
                }
            }

            if (heavierCount >= middlePoint || lighterCount >= middlePoint) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
