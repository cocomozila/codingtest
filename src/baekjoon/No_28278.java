package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_28278 {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int value = 0;
            if (order == 1) {
                value = Integer.parseInt(st.nextToken());
                method(order, value);
            } else {
                method(order);
            }
        }
        System.out.println(sb.toString());
    }

    private static void method(int orderNumber) {
        if (orderNumber == 2) {
            if (!stack.isEmpty()) {
                sb.append(stack.pop()).append("\n");
                return;
            }
            sb.append(-1).append("\n");

        } else if (orderNumber == 3) {
            sb.append(stack.size()).append('\n');

        } else if (orderNumber == 4) {
            if (stack.isEmpty()) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");

        } else {
            if (!stack.isEmpty()) {
                sb.append(stack.peek()).append("\n");
                return;
            }
            sb.append(-1).append("\n");
        }
    }

    private static void method(int orderNumber, int value) {
        stack.push(value);
    }
}
