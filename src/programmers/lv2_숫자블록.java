package programmers;

import java.util.Arrays;

public class lv2_숫자블록 {

    public static void main(String[] args) {
        int[] solution = solution(1, 10);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
    }

    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];

        for (long i = begin; i <= end; i++) {
            int index = (int)(i - begin);
            if (i == 1) {
                answer[index] = 0;
                continue;
            }

            int maxDivisor = 1; // 1은 모든 수의 약수
            boolean found = false;

            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    long other = i / j;
                    // 큰 약수가 10,000,000 이하인 경우 바로 할당
                    if (other <= 10_000_000) {
                        answer[index] = (int)other;
                        found = true;
                        break;
                    } else {
                        // 10,000,000 이상 약수 사용 불가하므로 일단 j를 기록
                        // j가 작을수록 i/j가 크므로, big 약수가 안되면 작은 약수 j를 기억
                        if (j > maxDivisor) {
                            maxDivisor = (int)j;
                        }
                    }
                }
            }

            // 적합한 약수를 못찾았을 경우 maxDivisor 할당
            if (!found) {
                answer[index] = maxDivisor;
            }
        }

        return answer;
    }


}
