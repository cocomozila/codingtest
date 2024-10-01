package programmers;

import java.util.PriorityQueue;

public class lv2_더_맵게 {

    public static void main(String[] args) {

        lv2_더_맵게 a = new lv2_더_맵게();
        int[] arr1 = {0,100};
        int K1 = 0;
        System.out.println(a.solution(arr1, K1));

    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (long num : scoville) {
            queue.add(num);
        }

        if (queue.peek() >= K) {
            return scoville.length - queue.size();
        }

        while (!queue.isEmpty()) {
            if (queue.peek() >= K) {
                return scoville.length - queue.size();
            }
            long num1 = queue.poll();
            long num2;
            if (!queue.isEmpty()) {
                num2 = queue.poll();
            } else {
                return -1;
            }
            long mix = num1 + (num2 * 2);
            queue.add(mix);
        }
        return -1;
    }
}
