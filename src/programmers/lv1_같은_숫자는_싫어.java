package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class lv1_같은_숫자는_싫어 {

    public static void main(String[] args) {

    }

    public int[] solution(int []arr) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == queue.peekLast()) {
                continue;
            }
            queue.add(arr[i]);
        }

        int size = queue.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
