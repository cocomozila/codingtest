package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_14284 {

    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        DP = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            DP[i] = 100_000_001;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        DP[startNode] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int next = poll.next;

            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            for (Node node : list[next]) {
                if (DP[node.next] > DP[next] + node.cost) {
                    DP[node.next] = DP[next] + node.cost;
                    queue.add(new Node(node.next, DP[node.next]));
                }
            }
        }

        System.out.println(DP[endNode]);
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
