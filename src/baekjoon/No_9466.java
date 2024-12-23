package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9466 {

    static int[] pick;               // pick[i] = i번째 학생이 '선택'한 학생
    static boolean[] visited;        // i번째 학생을 '방문'했는지 여부
    static boolean[] currentCycle;   // DFS 중 i번째 학생이 현재 '탐색 경로' 상에 있는지 여부
    static boolean[] done;           // i번째 학생을 '완전히 처리'했는지 여부(사이클 판별 완료)
    static int count;                // 사이클에 속한 학생들의 수(최종적으로 팀에 들어가는 학생 수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            pick = new int[n + 1];
            visited = new boolean[n + 1];
            currentCycle = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            String[] inputs = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(inputs[i - 1]);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int current) {
        visited[current] = true;
        currentCycle[current] = true;

        int nextStudent = pick[current];

        if (!visited[nextStudent]) {
            dfs(nextStudent);
        } else if (currentCycle[nextStudent] && !done[nextStudent]) {
            // nextStudent 는 이미 방문했지만,
            // nextStudent 가 아직 'currentCycle' 상에 있으며, 'done' 처리까지는 되지 않았다면,
            // 그것은 사이클을 의미한다.

            int temp = nextStudent;
            while (true) {
                count += 1;                // 사이클에 속한 학생을 카운트
                temp = pick[temp];     // 다음 노드 이동
                if (temp == nextStudent) {    // 다시 사이클의 시작점까지 오면 멈춘다.
                    break;
                }
            }
        }

        currentCycle[current] = false;
        done[current] = true;
    }
}
