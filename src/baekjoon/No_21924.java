package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_21924 {

    static long answer;
    static List<Node>[] list;
    static boolean[] visited;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new List[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, value));
            list[b].add(new Node(a, value));
            total += value;
        }
        prim(1);
        if (isNotConnected()) {
            System.out.println(-1);
            return;
        }
        System.out.println(total - answer);
    }

    static boolean isNotConnected() {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }

    static void prim(int startNode) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int to = pollNode.to;
            long value = pollNode.value;

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            answer += value;

            for (Node next : list[to]) {
                if (!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        long value;

        public Node(int to, long value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.value - o.value);
        }
    }
}
