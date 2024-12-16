package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_13549 {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList[100001];
        DP = new int[100001];
        visited = new boolean[100001];

        for (int i = 0; i < 100_001; i++) {
            list[i] = new ArrayList<>();
            if (i - 1 >= 0) {
                list[i].add(new Node(i - 1, 1));
            }
            if (i + 1 <= 100_000) {
                list[i].add(new Node(i + 1, 1));
            }
            if (i * 2 <= 100_000) {
                list[i].add(new Node(i * 2, 0));
            }
        }

        prim(N);
        System.out.println(DP[K]);
    }

    private static void prim(int startNode) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int target = poll.target;
            int cost = poll.cost;

            if (visited[target]) {
                continue;
            }

            visited[target] = true;
            DP[target] += cost;

            for (Node node : list[target]) {
                if (!visited[node.target]) {
                    queue.add(new Node(node.target, node.cost + cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
