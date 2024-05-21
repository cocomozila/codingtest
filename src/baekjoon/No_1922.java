package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1922 {

    static int answer;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        list = new List[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i < V + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, value));
            list[b].add(new Node(a, value));
        }
        prim(1);
        System.out.println(answer);
    }

    static void prim(int startNode) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int to = pollNode.to;
            int value = pollNode.value;

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
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
