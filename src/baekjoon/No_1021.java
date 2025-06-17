package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_1021 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        int[] arr = new int[M];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = 1; i <= N; i++) {
            queue1.addLast(i);
            queue2.addLast(i);
        }

        int total = 0;
        for (int i = 0; i < M; i++) {
            int number = arr[i];

            if (queue1.peekFirst() == number) {
                queue1.pollFirst();
                queue2 = new ArrayDeque<>(queue1);
            } else {
                int count1 = 0;
                int count2 = 0;
                while (true) {

                    if (queue1.peekFirst() == number) {
                        queue1.pollFirst();
                        total += count1;
                        queue2 = new ArrayDeque<>(queue1);
                        break;
                    } else {
                        queue1.addFirst(queue1.pollLast());
                        count1 += 1;
                    }

                    if (queue2.peekFirst() == number) {
                        queue2.pollFirst();
                        total += count2;
                        queue1 = new ArrayDeque<>(queue2);
                        break;
                    } else {
                        queue2.addLast(queue2.pollFirst());
                        count2 += 1;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
