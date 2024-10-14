package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv3_N으로_표현 {

    public static void main(String[] args) {
        lv3_N으로_표현 a = new lv3_N으로_표현();
//        System.out.println(a.solution(5, 12));
        System.out.println(a.solution(4, 31));

    }

    public int solution(int N, int number) {
        int[] DP = new int[1_000_01];
        int[] arr = {0, N, (N * 10) + N, (N * 100) + (N * 10) + N, (N * 1000) + (N * 100) + (N * 10) + N ,(N * 10000) + (N * 1000) + (N * 100) + (N * 10) + N};
        Arrays.fill(DP, 5000);
        DP[arr[1]] = 1;
        DP[arr[2]] = 2;
        DP[arr[3]] = 3;
        DP[arr[4]] = 4;
        DP[arr[5]] = 5;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[1]);
        queue.add(arr[2]);
        queue.add(arr[3]);
        queue.add(arr[4]);
        queue.add(arr[5]);

        int count = 0;

        while (!queue.isEmpty() && count <= 11111111) {
            int num = queue.poll();
            for (int j = 1; j < 6; j++) {
                for (int i = 0; i < 7; i++) {
                    count += 1;
                    switch (i) {
                        case 0:
                            if (isValid(num + arr[j])) {
                                DP[num + arr[j]] = Math.min(DP[num] + j, DP[num + arr[j]]);
                                queue.add(num + arr[j]);
                            }
                            break;
                        case 1:
                            if (isValid(num - arr[j])) {
                                DP[num - arr[j]] = Math.min(DP[num] + j, DP[num - arr[j]]);
                                queue.add(num - arr[j]);
                            }
                            break;
                        case 2:
                            if (isValid(num * arr[j])) {
                                DP[num * arr[j]] = Math.min(DP[num] + j, DP[num * arr[j]]);
                                queue.add(num * arr[j]);
                            }
                            break;
                        case 3:
                            if (isValid(num / arr[j])) {
                                DP[num / arr[j]] = Math.min(DP[num] + j, DP[num / arr[j]]);
                                queue.add(num / arr[j]);
                            }
                            break;
                        case 4:
                            if (isValid(arr[j] - num)) {
                                DP[arr[j] - num] = Math.min(DP[num] + j, DP[arr[j] - num]);
                                queue.add(arr[j] - num);
                            }
                            break;
                        case 5:
                            if (num != 0) {
                                if (isValid(arr[j] / num)) {
                                    DP[arr[j] / num] = Math.min(DP[num] + j, DP[arr[j] / num]);
                                    queue.add(arr[j] / num);
                                }
                            }
                            break;
                        case 6:
                            if (isValid(num - 1)) {
                                DP[num - 1] = Math.min(DP[num] + 2, DP[num - 1]);
                                queue.add(num - 1);
                            }
                    }
                }
            }
        }
        if (DP[number] > 8) {
            return -1;
        }
        return DP[number];
    }

    private boolean isValid(int num) {
        return num >= 0 && num <= 1_000_00;
    }
}
