package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1197 {

    static int answer;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        list = new ArrayList[P + 1];
        visited = new boolean[P + 1];

        for (int i = 0; i < P + 1; i++) { // list 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) { // 노드 생성
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
            int nodeTo = pollNode.to;
            int nodeValue = pollNode.value;

            if (visited[nodeTo]) {
                continue;
            }
            visited[nodeTo] = true;
            answer += nodeValue;

            for (Node next : list[nodeTo]) {
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
