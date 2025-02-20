package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_20920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Word> map = new HashMap<>();
        Queue<Word> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                Word word = map.get(s);
                word.addScore();
                map.put(s, word);
                continue;
            }
            map.put(s, new Word(s));
        }

        queue.addAll(map.values());

        while (!queue.isEmpty()) {
            Word poll = queue.poll();
            if (poll.isOverLength(M)) {
                sb.append(poll.word).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static class Word implements Comparable<Word> {
        String word;
        int length;
        int score;

        public Word(String word) {
            this.word = word;
            this.length = word.length();
            this.score = 0;
        }

        public void addScore() {
            this.score += 1;
        }

        public boolean isOverLength(int length) {
            return this.length >= length;
        }

        @Override
        public int compareTo(Word o) {
            if (this.score > o.score) {
                return -1;
            } else if (this.score < o.score) {
                return 1;
            } else {
                if (this.length > o.length) {
                    return -1;
                } else if (this.length < o.length) {
                    return 1;
                } else {
                    return word.compareTo(o.word);
                }
            }
        }
    }
}
