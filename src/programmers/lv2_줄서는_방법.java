package programmers;

import java.util.ArrayList;
import java.util.List;

public class lv2_줄서는_방법 {

    public static void main(String[] args) {
        lv2_줄서는_방법 a = new lv2_줄서는_방법();
        int[] solution = a.solution(5, 54);
        for (int b : solution) {
            System.out.print(b + " ");
        }
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long maxCombo = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            maxCombo *= i;
        }

        k -= 1;
        int index = 0;
        while (index < n) {
            maxCombo = maxCombo / (n - index);
            answer[index++] = list.remove((int) (k / maxCombo));
            k = k % maxCombo;
        }
        return answer;
    }
}
