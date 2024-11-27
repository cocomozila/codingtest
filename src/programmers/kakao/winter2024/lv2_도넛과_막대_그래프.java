package programmers.kakao.winter2024;

import java.util.HashMap;
import java.util.Map;

public class lv2_도넛과_막대_그래프 {

    public static void main(String[] args) {

    }

    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodes = new HashMap<>();

        int startNode = -1;
        int doughnut = 0;
        int stick = 0;
        int figure8 = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (!nodes.containsKey(from)) {
                nodes.put(from, new int[]{0, 0});
            }

            if (!nodes.containsKey(to)) {
                nodes.put(to, new int[]{0, 0});
            }

            nodes.get(from)[0] += 1;
            nodes.get(to)[1] += 1;
        }

        for (int key : nodes.keySet()) {
            int[] node = nodes.get(key);

            // 정점 노드 찾기
            if (node[0] >= 2 && node[1] == 0) {
                startNode = key;
            }

            // 막대그래프 찾기
            else if (node[0] == 0 && node[1] > 0) {
                stick += 1;
            }

            // 8자 그래프 찾기
            else if (node[0] >= 2 && node[1] >= 2) {
                figure8 += 1;
            }
        }
        doughnut = nodes.get(startNode)[0] - stick - figure8;

        return new int[]{startNode, doughnut, stick, figure8};
    }
}
