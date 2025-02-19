package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();

        for (int i = 0; i < words.length; i++) {
            if (Character.isUpperCase(words[i])) {
                words[i] = Character.toLowerCase(words[i]);
                continue;
            }
            words[i] = Character.toUpperCase(words[i]);
        }

        System.out.println(String.valueOf(words));
    }
}
