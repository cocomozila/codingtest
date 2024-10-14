package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lv3_네트워크 {

    static List<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) {
        lv3_네트워크 a = new lv3_네트워크();
        System.out.println(a.solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }

    public int solution(int n, int[][] computers) {
        initArrayList(n);
        initCheck(n);

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1 && j != i) {
                    list[i].add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int netWorkCount = 0;

        for (int i = 0; i < list.length; i++) {
            if (!check[i]) {
                queue.add(i);
                check[i] = true;

                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    if (!list[poll].isEmpty()) {
                        for (int a : list[poll]) {
                            if (!check[a]) {
                                queue.add(a);
                                check[a] = true;
                            }
                        }
                    }
                }
                netWorkCount += 1;
            }
        }
        return netWorkCount;
    }

    private void initArrayList(int n) {
        list = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private void initCheck(int n) {
        check = new boolean[n];
    }
}
