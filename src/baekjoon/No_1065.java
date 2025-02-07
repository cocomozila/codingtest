package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            return;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {

            String[] number = String.valueOf(i).split("");
            int d = 0;
            boolean flag = true;
            for (int j = 0; j < number.length - 1; j++) {
                int a = Integer.parseInt(number[j]);
                int b = Integer.parseInt(number[j + 1]);
                if (j == 0) {
                    d = b - a;
                    continue;
                }
                if (b - a != d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
