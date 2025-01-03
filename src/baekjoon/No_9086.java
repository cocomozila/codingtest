package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            sb.append(charArray[0])
                .append(charArray[charArray.length - 1])
                .append("\n");
        }
        System.out.print(sb.toString());
    }
}
