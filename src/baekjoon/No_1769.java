package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1769 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            if (N % 3 == 0) {
                sb.append(0).append("\n");
                sb.append("YES");
                return;
            }
            sb.append(0).append("\n");
            sb.append("NO");
            return;
        }

        String s = String.valueOf(N);
        int save = 0;
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                save += s.charAt(i);
            }
        }

    }
}
