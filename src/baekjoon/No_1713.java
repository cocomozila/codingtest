package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1713 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[M];
        Student[] students = new Student[101];
        int[] recommendations = new int[101];

        for (int i = 0; i <= 100; i++) {
            students[i] = new Student(i, 0);
        }

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Student> queue = new PriorityQueue<>(){};

        for (int i = 0; i < M; i++) {
            int number = arr[i];

            if (queue.size() < N) {
                if (queue.contains(students[number])) {
                    queue.remove(students[number]);
                    recommendations[number] += 1;
                    queue.add(new Student(number, recommendations[number], students[number].time));
                } else {
                    queue.add(new Student(number, 0, i));
                    students[number].time = i;
                }
            } else {
                if (queue.contains(students[number])) {
                    queue.remove(students[number]);
                    recommendations[number] += 1;
                    queue.add(new Student(number, recommendations[number], students[number].time));
                } else {
                    Student poll = queue.poll();
                    recommendations[poll.number] = 0;
                    students[poll.number].time = 0;
                    queue.add(new Student(number, 0, i));
                    students[number].time = i;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            list.add(queue.poll().number);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int number : list) {
            sb.append(number + " ");
        }

        System.out.println(sb.toString());
    }

    static class Student implements Comparable<Student> {
        int number;
        int recommend = 0;
        int time;

        public Student(int number, int time) {
            this.number = number;
            this.time = time;
        }

        public Student(int number, int recommend, int time) {
            this.number = number;
            this.recommend = recommend;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.recommend == o.recommend) {
                return this.time - o.time;
            } else {
                return this.recommend - o.recommend;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return this.number == ((Student) obj).number;
        }
    }
}
