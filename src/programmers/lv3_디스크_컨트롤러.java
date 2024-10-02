package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lv3_디스크_컨트롤러 {

    public static void main(String[] args) {
        lv3_디스크_컨트롤러 a = new lv3_디스크_컨트롤러();
        int[][] arr1 = {{0,1},{0,2},{1,6}};
        int[][] arr2 = {{0,3},{1,9},{2,6}};
        int[][] arr3 = {{0,1},{0,2},{0,3}};
        System.out.println(a.solution(arr1));
        System.out.println(a.solution(arr2));
        System.out.println(a.solution(arr3));
    }

    public int solution(int[][] jobs) {
        int now = 0;
        int count = 0;
        int jobsIndex = 0;
        int totalWorkTime = 0;

        PriorityQueue<Work> queue = new PriorityQueue<>();
        Arrays.sort(jobs, ((o1, o2) -> {return o1[0] - o2[0];}));

        while (count < jobs.length) {
            // 큐 채워넣기
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= now) {
                queue.add(new Work(jobs[jobsIndex][0], jobs[jobsIndex][1]));
                jobsIndex += 1;
            }
            if (queue.isEmpty()) {
                now = jobs[jobsIndex][0];
            } else {
                Work work = queue.poll();
                totalWorkTime += work.time + (now - work.request);
                now += work.time;
                count += 1;
            }
        }

        double answer = totalWorkTime / jobs.length;
        return (int) Math.floor(answer);
    }

    static class Work implements Comparable<Work> {
        int request;
        int time;

        public Work(int request, int time) {
            this.request = request;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            if (this.time > o.time) {
                return 1;
            } else if (this.time == o.time) {
                if (this.request > o.request) {
                    return 1;
                } else if (this.request == o.request) {
                    return 0;
                }
                return -1;
            }
            return -1;
        }
    }
}
