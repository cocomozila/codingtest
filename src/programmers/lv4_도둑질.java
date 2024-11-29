package programmers;

public class lv4_도둑질 {

    public int solution(int[] money) {
        int[] DP1 = new int[money.length];
        int[] DP2 = new int[money.length];

        DP1[0] = money[0];
        DP1[1] = money[1];
        DP1[2] = money[2] + money[0];

        DP2[0] = 0;
        DP2[1] = money[1];
        DP2[2] = money[2];

        if (money.length == 3) {
            return Math.max(money[0], Math.max(money[1], money[2]));
        }

        for (int i = 3; i < money.length; i++) {
            if (i != money.length - 1) {
                DP1[i] = Math.max(DP1[i - 2], DP1[i - 3]) + money[i];
            }
            DP2[i] = Math.max(DP2[i - 2], DP2[i - 3]) + money[i];
        }

        int answer = 0;
        for (int i = 0; i < DP1.length; i++) {
            answer = Math.max(answer, Math.max(DP1[i], DP2[i]));
        }
        return answer;
    }
}
