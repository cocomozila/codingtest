package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toLowerCase().toCharArray();

        int[] alphabet = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            alphabet[charArray[i] - 'a']++;
        }

        int max = 0;
        int maxAlphabet = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                maxAlphabet = i;
                list.clear();
            } else if (alphabet[i] == max) {
                list.add(i);
            }
        }

        if (list.size() > 0) {
            System.out.println("?");
            return;
        }
        System.out.println(Character.toUpperCase((char)(maxAlphabet + 'a')));
    }
}
