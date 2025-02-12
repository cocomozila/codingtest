package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        Queue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            long a = queue.poll();
            long b = 0;
            if (!queue.isEmpty()) {
                b = queue.poll();
            }

            answer += a + b;

            if (queue.isEmpty()) {
                break;
            }
            queue.add(a + b);
        }

        System.out.println(answer);
    }
}
