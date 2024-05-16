package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        String str = br.readLine();

        int result = 0;
        int multiple = 1;

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);

            if (isValidLeft(s)) {
                deque.addLast(s);
                multiple *= getMultiple(s);
            } else {
                if (!deque.isEmpty() && isEquals(deque, s)) {
                    if (s.equals(")")) {
                        if (str.substring(i - 1, i).equals("(")) {
                            result += multiple;
                        }
                        deque.pollLast();
                        multiple /= 2;
                    } else {
                        if (str.substring(i - 1, i).equals("[")) {
                            result += multiple;
                        }
                        deque.pollLast();
                        multiple /= 3;
                    }
                } else {
                    result = 0;
                    break;
                }
            }
        }
        if (!deque.isEmpty()) {
            result = 0;
        }
        System.out.println(result);
    }

    private static boolean isEquals(Deque<String> deque, String s) {
        if (deque.peekLast().equals("(") && s.equals(")")) {
            return true;
        } else if (deque.peekLast().equals("[") && s.equals("]")) {
            return true;
        }
        return false;
    }

    private static int getMultiple(String str) {
        return str.equals("(") ? 2 : 3;
    }

    private static boolean isValidLeft(String str) {
        return str.equals("(") || str.equals("[");
    }
}
