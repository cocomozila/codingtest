package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1032 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        char[][] files = new char[T][];
        for (int i = 0; i < T; i++) {
            files[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < files[0].length; i++) {
            boolean flag = true;
            for (int j = 0; j < T; j++) {
                if (files[j][i] != files[0][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(files[0][i]);
                continue;
            }
            sb.append("?");
        }
        System.out.println(sb.toString());
    }
}
