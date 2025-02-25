package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_7567 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        int answer = 10;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == '(') {
                if (c[i - 1] == ')') {
                    answer += 10;
                } else {
                    answer += 5;
                }
            } else {
                if (c[i - 1] == '(') {
                    answer += 10;
                } else {
                    answer += 5;
                }
            }
        }
        System.out.println(answer);
    }
}
