package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(",");
            sb.append(Integer.parseInt(split[0]) + Integer.parseInt(split[1])).append("\n");
        }

        System.out.print(sb.toString());
    }
}
