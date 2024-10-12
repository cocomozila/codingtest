package programmers;

import java.util.Arrays;

public class lv1_K번째수 {

    public static void main(String[] args) {
        lv1_K번째수 a = new lv1_K번째수();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] bbb = {{2,5,3},{4,4,1},{1,7,3}};
        int[] solution = a.solution(arr, bbb);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] copy = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copy);
            answer[i] = copy[commands[i][2] - 1];
        }
        return answer;
    }
}
