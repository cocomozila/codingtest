package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11721 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        int count = 0;
        int index = 0;
        while (index < str.length()) {
            sb.append(str.charAt(index));
            index += 1;
            count += 1;
            if (count == 10) {
                sb.append("\n");
                count = 0;
            }
        }
        System.out.println(sb.toString());
    }
}
