package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 가장 작은 생성자를 찾아 저장할 변수
        // (찾지 못하면 0 출력)
        int answer = 0;

        // i는 1부터 시작해도 되고(0 넣어봐도 문제는 X),
        // 최악의 경우 N까지 전부 탐색.
        for (int i = 1; i <= N; i++) {
            int num = i;
            int total = num;

            // i의 각 자릿수를 더해줌
            while (num > 0) {
                total += num % 10;
                num /= 10;
            }

            // 분해합이 N과 일치하면 i는 N의 생성자
            if (total == N) {
                answer = i;
                break;
            }
        }

        // 생성자를 찾았으면 answer != 0, 못 찾았으면 그대로 0
        System.out.println(answer);
    }
}
