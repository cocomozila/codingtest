package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1854 {

    static int N, M, K;
    static List<Node>[] list;
    static Queue<Integer>[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new PriorityQueue[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int cost = node.cost;

            if (dist[next].size() >= K) {
                continue;
            }

            dist[next].add(cost);

            for (Node n : list[next]) {
                queue.add(new Node(n.next, n.cost + cost));
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() < K) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i].poll()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node> {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
