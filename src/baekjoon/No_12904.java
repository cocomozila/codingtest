package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String word = br.readLine();

        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder(word));

        while (!queue.isEmpty()) {
            StringBuilder poll = queue.poll();
            if (poll.length() < target.length()) {
                System.out.println(0);
                return;
            }

            if (poll.toString().equals(target)) {
                System.out.println(1);
                return;
            }

            if (poll.charAt(poll.length() - 1) == 'A') {
                StringBuilder a = poll.deleteCharAt(poll.length() - 1);
                queue.add(a);
                continue;
            }
            StringBuilder a = poll.deleteCharAt(poll.length() - 1);
            a.reverse();
            queue.add(a);
        }
    }
}
