package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_18352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> answer = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startCity, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int city = poll[0];
            int dist = poll[1];

            if (visited[city]) {
                continue;
            }

            visited[city] = true;

            if (dist == distance) {
                answer.add(city);
                continue;
            }

            for (int c : list[city]) {
                queue.add(new int[]{c, dist + 1});
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
            return;
        }

        while (!answer.isEmpty()) {
            sb.append(answer.poll()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
