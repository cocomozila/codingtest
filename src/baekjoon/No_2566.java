package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2566 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int y = 0;
        int x = 0;
        int max = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number > max) {
                    y = i;
                    x = j;
                    max = number;
                }
            }
        }
        sb.append(max).append("\n").append(y + 1).append(" ").append(x + 1);
        System.out.println(sb.toString());
    }
}
