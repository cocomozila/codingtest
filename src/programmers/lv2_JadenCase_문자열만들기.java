package programmers;

public class lv2_JadenCase_문자열만들기 {

    public static void main(String[] args) {
        String str = "    3people   unFollowed    me";
        System.out.println(solution(str));
    }

    public static String solution(String s) {
        String lowerCase = s.toLowerCase();
        char[] arr = lowerCase.toCharArray();

        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (!check) {
                if (arr[i] != ' ') {
                    check = true;
                    arr[i] = Character.toUpperCase(arr[i]);
                }
            } else {
                if (arr[i] == ' ') {
                    check = false;
                }
            }
        }
        return String.valueOf(arr);
    }
}
