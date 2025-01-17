package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_10282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        List<Node>[] list;
        boolean[] visited;

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int infected = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            Queue<Node> queue = new PriorityQueue<>();
            int max = 0;
            int count = 0;

            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a, c));
            }

            queue.add(new Node(infected, 0));

            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                int next = poll.next;
                int cost = poll.cost;

                if (visited[next]) {
                    continue;
                }

                max = Math.max(max, cost);
                count += 1;

                visited[next] = true;
                for (Node node : list[next]) {
                    queue.add(new Node(node.next, node.cost + cost));
                }
            }
            sb.append(count + " " + max).append("\n");
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
