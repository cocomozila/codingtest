package programmers;

import java.util.Arrays;

public class lv1_체육복 {

    public static void main(String[] args) {
        lv1_체육복 a = new lv1_체육복();
        int n = 5;
        int[] lost = {2,3,5};
        int[] reserve = {1,4,5};
        System.out.println(a.solution(n, lost, reserve));

        int n1 = 10;
        int[] lost1 = {4,7};
        int[] reserve1 = {1,6,8};
        System.out.println(a.solution(n1, lost1, reserve1));
    }

    public int solution(int n, int[] lost, int[] reserve) {

        boolean[] arr = new boolean[n + 1];

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]] = true;
        }

        for (int i = 0; i < reserve.length; i++) {
            if (arr[reserve[i]]) {
                arr[reserve[i]] = false;
                reserve[i] = 0;
            }
        }

        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            int num = reserve[i];
            if (num > 1 && num < n) {
                if (arr[num - 1]) {
                    arr[num - 1] = false;
                } else {
                    arr[num + 1] = false;
                }
            } else if (num == 1) {
                if (arr[num + 1]) {
                    arr[num + 1] = false;
                }
            } else if (num == n) {
                if (arr[num - 1]) {
                    arr[num - 1] = false;
                }
            }
        }
        int answer = 0;

        for (int i = 1; i < arr.length; i++) {
            answer += arr[i] ? 0 : 1;
        }
        return answer;
    }
}
