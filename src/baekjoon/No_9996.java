package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9996 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        StringBuilder sb = new StringBuilder();

        String prefix = st.nextToken();
        String suffix = st.nextToken();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < prefix.length() + suffix.length()) {
                sb.append("NE").append("\n");
                continue;
            }
            if (!word.substring(0, prefix.length()).equals(prefix)) {
                sb.append("NE").append("\n");
                continue;
            }
            if (!word.substring(word.length() - suffix.length()).equals(suffix)) {
                sb.append("NE").append("\n");
                continue;
            }
            sb.append("DA").append("\n");
        }

        System.out.println(sb.toString());
    }
}
