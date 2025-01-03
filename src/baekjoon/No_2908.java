package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String A = String.valueOf(st.nextElement());
        String B = String.valueOf(st.nextElement());

        String C = null;
        for (int i = A.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(String.valueOf(A.charAt(i)));
            int b = Integer.parseInt(String.valueOf(B.charAt(i)));
            if (a > b) {
                C = A;
                break;
            } else if (a < b) {
                C = B;
                break;
            }
        }

        for (int i = C.length() - 1; i >= 0; i--) {
            sb.append(C.charAt(i));
        }

        System.out.println(sb.toString());
    }
}
