package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_12891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] pRes = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int answer = 0;
        int[] arr = new int[4];

        for (int i = 0; i < P; i++) {
            arr[getNumber(DNA.charAt(i))] += 1;
        }

        for (int i = P; i < DNA.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (arr[j] < pRes[j]) {
                    flag = false;
                    break;
                }
            }
            if (i < DNA.length()) {
                arr[getNumber(DNA.charAt(i))] += 1;
                arr[getNumber(DNA.charAt(i - P))] -= 1;
            }
            if (flag) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    public static int getNumber(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }
}
