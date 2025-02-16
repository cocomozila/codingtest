package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();

        int right = words.length - 1;
        int left = 0;
        while (left < right) {
            if (words[left++] != words[right--]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
