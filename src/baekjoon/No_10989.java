package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[num]++;
        }

        int count = N;

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] > 0) {
                sb.append(i).append("\n");
                numbers[i] -= 1;
                count -= 1;
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(sb.toString());
    }
}
