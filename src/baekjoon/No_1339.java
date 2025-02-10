package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();

            int index = 0;
            for (int j = charArray.length - 1; j >= 0; j--) {
                alphabet[charArray[index++] - 'A'] += Math.pow(10, j);
            }
        }

        Arrays.sort(alphabet);

        int answer = 0;
        int index = 9;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (index < 0) {
                break;
            }
            answer += alphabet[i] * index;
            index -= 1;
        }

        System.out.println(answer);
    }
}
