package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_25314 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            sb.append("long ");
            N -= 4;
        }
        sb.append("int");

        System.out.println(sb.toString());
    }
}
