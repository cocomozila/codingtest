package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] map = new char[5][];

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    sb.append(map[j][i]);
                } catch (Exception e) {
                }
            }
        }
        System.out.println(sb.toString());
    }
}
