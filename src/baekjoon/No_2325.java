package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2325 {

    static int N, M;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static int[] save;
    static int answer = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        dist = new int[N + 1];
        save = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        dijkstra(1, new int[]{-1, -1});
        flag = true;
        answer = dist[N];

        for (int i = N; i > 1;) {
            dist = new int[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(1, new int[]{save[i], i});
            answer = Math.max(answer, dist[N]);
            i = save[i];
        }
        System.out.println(answer);

    }

    private static void dijkstra(int startNode, int[] banRoad) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;

            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            for (Node n : list[next]) {
                if ((next == banRoad[0] && n.next == banRoad[1]) ||
                    (next == banRoad[1] && n.next == banRoad[0])) {
                    continue;
                }
                if (dist[n.next] > dist[next] + n.cost) {
                    dist[n.next] = dist[next] + n.cost;
                    if (!flag) {
                        save[n.next] = next;
                    }
                    queue.add(new Node(n.next, dist[n.next]));
                }
            }
        }
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
