package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2294 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] DP = new int[K+1];

        Set<Integer> set = new HashSet();

        for (int i = 0; i < N; i++) {
            int readNumber = Integer.parseInt(br.readLine());
            if (readNumber <= K) {
                set.add(readNumber);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(set);
        Arrays.fill(DP, Integer.MAX_VALUE - 1);
        DP[0] = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            for (int j = poll; j <= K; j++) {
                DP[j] = Math.min(DP[j], DP[j-poll] + 1);
            }
        }

        int answer = DP[K] == Integer.MAX_VALUE - 1 ? -1 : DP[K];
        System.out.println(answer);

    }
}
