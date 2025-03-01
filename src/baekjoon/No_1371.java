package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1371 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];

        String str;
        while ((str = br.readLine()) != null) {
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                    alphabet[charArray[i] - 'a']++;
                }
            }
        }

        List<Character> list = new ArrayList<Character>();
        int max = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                list.clear();
                list.add((char) (i + 'a'));
            } else if (alphabet[i] == max) {
                list.add((char) (i + 'a'));
            }
        }
        System.out.println(a);
    }
}
