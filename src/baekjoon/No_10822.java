package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10822 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        int answer = 0;
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }
        System.out.println(answer);
    }
}
