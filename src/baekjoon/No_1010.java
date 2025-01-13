package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No_1010 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            BigInteger top = BigInteger.valueOf(1);
            for (int j = 1; j <= n; j++) {
                top = top.multiply(BigInteger.valueOf(j));
            }

            int a = n - r;
            BigInteger bottom = BigInteger.valueOf(1);
            for (int j = 1; j <= a; j++) {
                bottom = bottom.multiply(BigInteger.valueOf(j));
            }

            BigInteger bottom2 = BigInteger.valueOf(1);
            for (int j = 1; j <= r; j++) {
                bottom2 = bottom2.multiply(BigInteger.valueOf(j));
            }

            bottom = bottom.multiply(bottom2);
            BigInteger answer = top.divide(bottom);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
