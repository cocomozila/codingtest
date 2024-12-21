package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_15681 {

    static int N, R, Q;
    static List<Integer>[] list, tree;
    static int[] parentArr;
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];
        parentArr = new int[N + 1];
        size = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        makeTree(R, -1);
        countSubtree(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(size[num]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void makeTree(int currentNode, int parent) {
        for (int node : list[currentNode]) {
            if (node != parent) {
                tree[currentNode].add(node);
                parentArr[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }

    public static void countSubtree(int currentNode) {
        size[currentNode] = 1;
        for (int node : tree[currentNode]) {
            countSubtree(node);
            size[currentNode] += size[node];
        }
    }
}
