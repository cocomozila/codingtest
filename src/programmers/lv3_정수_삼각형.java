package programmers;

public class lv3_정수_삼각형 {

    public static void main(String[] args) {
        lv3_정수_삼각형 aa = new lv3_정수_삼각형();
        int[][] arr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(aa.solution(arr));
    }

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] DP = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            DP[i] = new int[triangle[i].length];
        }

        DP[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    DP[i][j] = DP[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    DP[i][j] = DP[i - 1][j - 1] + triangle[i][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j - 1], DP[i - 1][j]) + triangle[i][j];
                }
            }
        }

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, DP[triangle.length - 1][i]);
        }
        return answer;
    }
}
