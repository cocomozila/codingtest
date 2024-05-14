package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int passengers = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            passengers -= Integer.parseInt(st.nextToken());
            passengers += Integer.parseInt(st.nextToken());
            max = Math.max(passengers, max);
        }
        System.out.println(max);
    }
}
