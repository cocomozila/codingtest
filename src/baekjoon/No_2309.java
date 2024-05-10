package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2309 {

    static int[] allDwarf = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = 0;

        for (int i = 0; i < 9; i++) {
            allDwarf[i] = Integer.parseInt(br.readLine());
            total += allDwarf[i];
        }
        Arrays.sort(allDwarf);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - (allDwarf[i] + allDwarf[j]) == 100) {
                    print(i, j, sb);
                    return;
                }
            }
        }
    }

    static void print(int i, int j, StringBuilder sb) {
        for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
                sb.append(allDwarf[k]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
