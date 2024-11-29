package programmers;

import java.util.*;

public class lv3_섬_연결하기 {

    List<Node>[] nodes;
    boolean[] visited;

    public int solution(int n, int[][] costs) {
        nodes = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < costs.length; i++) {
            nodes[costs[i][0]].add(new Node(costs[i][1], costs[i][2]));
            nodes[costs[i][1]].add(new Node(costs[i][0], costs[i][2]));
        }

        return prim(1);
    }

    private int prim(int startNode) {
        int answer = 0;
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

            for (Node next : nodes[nodeTo]) {
                if (!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
        return answer;
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
