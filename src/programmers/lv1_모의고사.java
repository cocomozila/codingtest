package programmers;

import java.util.ArrayList;

public class lv1_모의고사 {

    public static void main(String[] args) {
        lv1_모의고사 a = new lv1_모의고사();
        int[] arr1 = {1,3,2,4,2};
        int[] solution = a.solution(arr1);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] answers) {
        int[] answer = {0, 0 ,0};
        int[] index = {0, 0, 0};
        Integer max = 0;


        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[][] students = {student1, student2, student3};

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == students[j][index[j]]) {
                    answer[j] += 1;
                }
                if (index[j] == students[j].length - 1) {
                    index[j] = 0;
                } else {
                    index[j] += 1;
                }
            }
        }
        max = Math.max(max, Math.max(answer[0], Math.max(answer[1], answer[2])));
        System.out.println("max = " + max);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == answer[i]) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
