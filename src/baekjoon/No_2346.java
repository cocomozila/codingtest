package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_2346 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        int order = 0;
        while (!deque.isEmpty()) {
            while (order != 0) {
                if (order > 0) {
                    order -= 1;
                    deque.addLast(deque.pollFirst());
                } else if (order < 0) {
                    order += 1;
                    deque.addFirst(deque.pollLast());
                }
            }
            Balloon balloon = deque.pollFirst();
            if (balloon.value > 0) {
                order = balloon.value - 1;
            } else {
                order = balloon.value;
            }
            sb.append(balloon.no + " ");
        }

        System.out.println(sb.toString());
    }

    static class Balloon {
        int no;
        int value;

        public Balloon(int no, int value) {
            this.no = no;
            this.value = value;
        }
    }
}
