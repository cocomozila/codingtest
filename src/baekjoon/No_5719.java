package baekjoon;

import java.io.*;
import java.util.*;

public class No_5719 {

    static int N, M, start, end;
    static List<Node>[] list;
    static List<Integer>[] parents;
    static boolean[][] removed;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }

            parents = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                parents[i] = new ArrayList<>();
            }
            removed = new boolean[N][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, c));
            }

            int[] dist1 = firstDijkstra();
            if (dist1[end] == INF) {
                sb.append(-1).append("\n");
                continue;
            }

            removeEdges(end);

            int[] dist2 = secondDijkstra();
            int answer = dist2[end];
            sb.append(answer == INF ? -1 : answer).append("\n");
        }

        System.out.print(sb);
    }

    private static int[] firstDijkstra() {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.next;
            int cost = cur.cost;

            if (cost > dist[now]) continue;

            for (Node nxt : list[now]) {
                int nextNode = nxt.next;
                int nextDist = cost + nxt.cost;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    parents[nextNode].clear();
                    parents[nextNode].add(now);
                    pq.offer(new Node(nextNode, nextDist));
                } else if (nextDist == dist[nextNode]) {
                    parents[nextNode].add(now);
                }
            }
        }

        return dist;
    }

    private static void removeEdges(int node) {
        if (node == start) return;

        for (int p : parents[node]) {
            if (!removed[p][node]) {
                removed[p][node] = true;
                removeEdges(p);
            }
        }
    }

    private static int[] secondDijkstra() {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.next;
            int cost = cur.cost;

            if (cost > dist[now]) continue;

            for (Node nxt : list[now]) {
                int nextNode = nxt.next;
                if (removed[now][nextNode]) continue;

                int nextDist = cost + nxt.cost;
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new Node(nextNode, nextDist));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int next, cost;
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
