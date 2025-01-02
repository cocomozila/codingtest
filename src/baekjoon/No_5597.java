package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5597 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int studentNumber = Integer.parseInt(br.readLine());
            arr[studentNumber - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!arr[i]) {
                sb.append(i + 1).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
