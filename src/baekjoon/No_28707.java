package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_28707 {

    static int N, M;
    static int[] tokens;
    static int[] answer;
    static SortOrder[] sortOrders;
    static Map<String, Integer> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tokens = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tokens[i] = Integer.parseInt(st.nextToken());
        }

        answer = tokens.clone();
        Arrays.sort(answer);

        M = Integer.parseInt(br.readLine());
        sortOrders = new SortOrder[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sortOrders[i] = new SortOrder(a - 1, b - 1, c);
        }

        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(tokens, 0));
        visited.put(Arrays.toString(tokens), 0);

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();

            if (Arrays.equals(pollNode.arr, answer)) {
                System.out.println(pollNode.cost);
                return;
            }

            for (SortOrder order : sortOrders) {
                int[] change = order.change(pollNode.arr);

                int newCost = pollNode.cost + order.cost;
                String newState = Arrays.toString(change);

                if (!visited.containsKey(newState) || visited.get(newState) > newCost) {
                    queue.offer(new Node(change, newCost));
                    visited.put(newState, newCost);
                }
            }
        }
        System.out.println(-1);
    }

    static class SortOrder {
        int before;
        int after;
        int cost;

        public SortOrder(int before, int after, int cost) {
            this.before = before;
            this.after = after;
            this.cost = cost;
        }

        public int[] change(int[] arr) {
            int[] clone = arr.clone();
            int temp = clone[before];
            clone[before] = clone[after];
            clone[after] = temp;
            return clone;
        }
    }

    static class Node implements Comparable<Node> {
        int[] arr;
        int cost;

        public Node(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
