package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, (a, b) -> a[0] - b[0]);

        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= lectures[i][0]) {
                queue.poll();
            }
            queue.offer(lectures[i][1]);
        }

        System.out.println(queue.size());
    }
}
