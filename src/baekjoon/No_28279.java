package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_28279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int value = 0;

            if (order == 1) {
                value = Integer.parseInt(st.nextToken());
                deque.addFirst(value);

            } else if (order == 2) {
                value = Integer.parseInt(st.nextToken());
                deque.addLast(value);

            } else if (order == 3) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }

            } else if (order == 4) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }

            } else if (order == 5) {
                sb.append(deque.size()).append("\n");

            } else if (order == 6) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else if (order == 7) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }

            } else if (order == 8) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
