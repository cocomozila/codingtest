package programmers;

import java.util.Arrays;

public class lv1_최소직사각형 {

    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < sizes.length; i++) {
            int num1 = sizes[i][0];
            int num2 = sizes[i][1];
            if (num2 > num1) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            max1 = Math.max(max1, num1);
            max2 = Math.max(max2, num2);
        }

        return max1 * max2;
    }
}
