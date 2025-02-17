package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String s = br.readLine();

        int answer = 0;
        aa : for (int i = 0; i < word.length() - s.length() + 1; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (word.charAt(i + j) == s.charAt(j)) {
                    continue;
                }
                continue aa;
            }
            i += s.length() - 1;
            answer += 1;
        }

        System.out.println(answer);

    }
}
