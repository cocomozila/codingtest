package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1264 {

    static char[] findWords = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (true) {
            line = br.readLine();
            char[] charArray = line.toCharArray();
            int count = 0;
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < findWords.length; j++) {
                    if (charArray[i] == findWords[j]) {
                        count += 1;
                        break;
                    }
                }
            }
            if (charArray[0] == '#') {
                break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
