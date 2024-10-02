package programmers;


import java.util.*;

public class lv3_이중우선순위큐 {

    public static void main(String[] args) {
        lv3_이중우선순위큐 a = new lv3_이중우선순위큐();
//        String[] str = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        int[] solution = a.solution(str);
//        System.out.println(solution[0] + " " + solution[1]);

        String[] str2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] solution2 = a.solution(str2);
        System.out.println(solution2[0] + " " + solution2[1]);
    }

    public int[] solution(String[] operations) {
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String order = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if (order.equals("I")) {
                queue.add(number);
                queue2.add(number);
            } else {
                if (!queue.isEmpty()) {
                    if (number == 1) {
                        int poll = queue2.poll();
                        queue.remove(poll);
                    } else {
                        int poll = queue.poll();
                        queue2.remove(poll);
                    }
                }
            }
        }
        int[] answer = new int[2];
        if (!queue.isEmpty()) {
            answer[0] = queue2.poll();
            answer[1] = queue.poll();
            return answer;
        }
        return answer;
    }
}
