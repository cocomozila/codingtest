package programmers;

public class lv2_큰_수_만들기 {

    public static void main(String[] args) {
        lv2_큰_수_만들기 aa = new lv2_큰_수_만들기();
        String str1 = "1924";
        String str2 = "1231234";
        String str3 = "4177252841";
        String str4 = "333222111";


        System.out.println(aa.solution(str1, 2));
        System.out.println(aa.solution(str2, 3));
        System.out.println(aa.solution(str3, 4));
        System.out.println(aa.solution(str4, 6));
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
