package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_16398 {

    static long answer;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 1;
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if (index != i) {
                    list[i].add(new Node(index, value));
                }
                index += 1;
            }
        }

        prim(1);
        System.out.println(answer);

    }

    static void prim(int firstNode) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(firstNode, 0));
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
