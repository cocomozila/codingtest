package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11719 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word;
        while ((word = br.readLine()) != null) {
            sb.append(word).append("\n");
        }
        System.out.println(sb.toString());
    }
}
