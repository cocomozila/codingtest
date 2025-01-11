package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2629 {

    static int N, M;
    static int[] arr;
    static boolean[][] sinker;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        sinker = new boolean[N + 1][40001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (sinker[N][number]) {
                sb.append("Y ");
                continue;
            }
            sb.append("N ");
        }

        System.out.println(sb.toString());
    }

    static void dp(int count, int num) {
        if (sinker[count][num]) {
            return;
        }
        sinker[count][num] = true;

        if (count == N) {
            return;
        }

        dp(count + 1, num + arr[count]);
        dp(count + 1, num);
        dp(count + 1, Math.abs(num - arr[count]));
    }
}
