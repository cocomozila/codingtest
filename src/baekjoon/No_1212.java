package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();

        if(octal.equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();

        int firstDigit = octal.charAt(0) - '0';
        sb.append(Integer.toBinaryString(firstDigit));

        for (int i = 1; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            String bin = Integer.toBinaryString(digit);

            while (bin.length() < 3) {
                bin = "0" + bin;
            }
            sb.append(bin);
        }

        System.out.println(sb.toString());
    }
}
