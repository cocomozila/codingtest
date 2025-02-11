package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negative = new PriorityQueue<>();
        int zeroCount = 0;

        int total = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positive.add(number);
            } else if (number < 0) {
                negative.add(number);
            } else {
                zeroCount += 1;
            }
            total += number;
        }

        if ((positive.size() + negative.size()) == 1) {
            System.out.println(total);
            return;
        }

        while (!positive.isEmpty()) {
            int a = positive.poll();
            int b = 1;

            if (!positive.isEmpty()) {
                b = positive.poll();
            }

            int sum = a + b;
            if (a * b > sum) {
                total -= sum;
                total += a * b;
            }
        }

        while (!negative.isEmpty()) {
            int a = negative.poll();

            if (!negative.isEmpty()) {
                int b = negative.poll();

                total -= a + b;
                total += a * b;
            } else {
                if (zeroCount > 0) {
                    zeroCount -= 1;
                    total -= a;
                }
            }
        }

        System.out.println(total);
    }
}
