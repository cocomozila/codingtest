package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_11779 {

    static int N, M;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] DP;
    static int[] route;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        visited = new boolean[N + 1];
        DP = new int[N + 1];
        route = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new LinkedList<>();
            DP[i] = Integer.MAX_VALUE - 1;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        prim(start);
        sb.append(DP[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(end);

        int index = end;
        while (route[index] != 0) {
            index = stack.peek();
            if (route[index] != 0) {
                stack.push(route[index]);
            }
        }

        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void prim(int currentNode) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(currentNode, 0));
        DP[currentNode] = 0;

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int next = pollNode.next;

            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            for (Node node : list[next]) {
                if (DP[node.next] > DP[next] + node.cost) {
                    DP[node.next] = DP[next] + node.cost;
                    queue.add(new Node(node.next, DP[node.next]));
                    route[node.next] = next;
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
