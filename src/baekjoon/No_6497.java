package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_6497 {

    static int answer;
    static List<Node>[] list;
    static boolean[] visited;
    static int total = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            answer = 0;
            total = 0;

            if (V == 0 && E == 0) {
                break;
            }

            list = new List[V + 1];
            visited = new boolean[V + 1];

            for (int i = 0; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            int start = 0;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, value));
                list[b].add(new Node(a, value));
                total += value;
                start = a;
            }
            prim(start);
            System.out.println(total - answer);
        }

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
