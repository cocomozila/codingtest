package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        boolean[] isQueue = new boolean[N];
        // 0 : Queue
        // 1 : Stack

        StringTokenizer values = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int queueOrStack = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(values.nextToken());
            if (queueOrStack == 0) {
                deque.addLast(value);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.addFirst(num);
            sb.append(deque.pollLast())
                .append(" ");
        }
        System.out.println(sb.toString());
    }
}
