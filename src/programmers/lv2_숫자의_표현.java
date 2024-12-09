package programmers;

public class lv2_숫자의_표현 {

    public int solution(int n) {

        int answer = 0;

        int right = n / 2 + 1;
        int left = right - 1;

        int sum = right + left;
        while (left > 0) {
            if (sum == n) {
                answer += 1;
                sum -= right;
                right -= 1;
                left -= 1;
                sum += left;
            } else if (sum > n) {
                sum -= right;
                right -= 1;
                left -= 1;
                sum += left;
            } else {
                left -= 1;
                sum += left;
            }
        }
        return answer + 1;
    }
}
