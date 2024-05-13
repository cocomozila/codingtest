package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            char[] array = numberToByte(num).toCharArray();

            int counter = 0;
            for (int j = array.length - 1; j >= 0; j--) {
                if (array[j] == '1') {
                    sb.append(counter + " ");
                }
                counter += 1;
            }
        }
        System.out.println(sb);
    }

    static String numberToByte(int n) {
        return Integer.toBinaryString(n);
    }
}
