package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10808 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();

        int[] alphabet = new int[26];

        for (int i = 0; i < arr.length; i++) {
            alphabet[arr[i] - 'a']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
