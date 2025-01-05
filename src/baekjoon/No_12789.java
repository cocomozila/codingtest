package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_12789 {

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> side = new Stack<>();
        Stack<Integer> fin = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        fin.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while (true) {
            if (!queue.isEmpty()) {
                if (fin.peek() + 1 == queue.peek()) {
                    fin.push(queue.poll());
                } else if (!side.isEmpty() && fin.peek() + 1 == side.peek()) {
                    fin.push(side.pop());
                } else {
                    side.push(queue.poll());
                }
            } else {
                if (!side.isEmpty()) {
                    if (fin.peek() + 1 == side.peek()) {
                        fin.push(side.pop());
                    } else {
                        System.out.println("Sad");
                        return;
                    }
                } else {
                    System.out.println("Nice");
                    return;
                }
            }
        }
    }
}
