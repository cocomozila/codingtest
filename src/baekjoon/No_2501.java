package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_2501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i < (N / 2) + 1; i++) {
            if (N % i == 0) {
                list.add(i);
                if (list.size() == K) {
                    System.out.println(list.get(K - 1));
                    return;
                }
            }
        }
        list.add(N);
        if (list.size() < K) {
            System.out.println(0);
            return;
        }
        System.out.println(list.get(K - 1));

    }
}
