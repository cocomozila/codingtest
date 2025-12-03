package baekjoon;

import java.io.*;
import java.util.*;

public class No_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] count = new int[8001];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            count[num + 4000]++;

            if (num > max) max = num;
            if (num < min) min = num;
        }

        int mean = (int)Math.round((double)sum / N);

        int midCount = 0;
        int median = 0;
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (count[i] > 0) {
                midCount += count[i];
                if (midCount >= (N / 2) + 1) {
                    median = i - 4000;
                    break;
                }
            }
        }

        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }

        List<Integer> frequent = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                frequent.add(i - 4000);
            }
        }
        Collections.sort(frequent);
        int mode = (frequent.size() > 1) ? frequent.get(1) : frequent.get(0);

        int range = max - min;

        StringBuilder sb = new StringBuilder();
        sb.append(mean).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range).append("\n");
        System.out.println(sb.toString());
    }
}
