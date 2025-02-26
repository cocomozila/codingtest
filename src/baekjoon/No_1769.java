package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1769 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int count = 0;

        if (s.length() == 1) {
            sb.append(0).append("\n");
            sb.append(isDivisibleBy3(s) ? "YES" : "NO");
            System.out.println(sb.toString());
            return;
        }

        while (s.length() > 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            s = String.valueOf(sum);
            count++;
        }

        sb.append(count).append("\n");
        sb.append(isDivisibleBy3(s) ? "YES" : "NO");
        System.out.println(sb.toString());
    }

    private static boolean isDivisibleBy3(String s) {
        int num = Integer.parseInt(s);
        return num % 3 == 0;
    }
}
