package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = mod(a, b);
        int d = (a * b) / c;

        sb.append(c).append("\n").append(d);
        System.out.println(sb);
    }

    private static int mod(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);

        while (true) {
            int num = max % min;
            if (num == 0) {
                return min;
            } else {
                max = min;
                min = num;
            }
        }
    }
}
