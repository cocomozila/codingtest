package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000];

        int number = 1;
        int index = 0;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                arr[index] = number;
                index += 1;
                if (index == 1000) {
                    break;
                }
            }
            if (index == 1000) {
                break;
            }
            number += 1;
        }

        int sum = 0;

        for (int i = start - 1; i < end; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
