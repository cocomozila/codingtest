package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_5972 {

    static List<Node>[] list;
    static boolean[] visited;
    static int[] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        visited = new boolean[N + 1];
        DP = new int[N + 1];

        Arrays.fill(DP, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        DP[1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;

            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            for (Node n : list[next]) {
                if (DP[n.next] > DP[next] + n.cost) {
                    DP[n.next] = DP[next] + n.cost;
                    queue.add(new Node(n.next, DP[n.next]));
                }
            }
        }

        System.out.println(DP[N]);
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
