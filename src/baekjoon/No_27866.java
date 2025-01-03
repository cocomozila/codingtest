package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_27866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabets = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());

        System.out.println(alphabets[n - 1]);
    }
}
