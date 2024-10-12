package programmers;

import java.util.Arrays;

public class lv2_가장_큰_수 {

    public static void main(String[] args) {
        lv2_가장_큰_수 a = new lv2_가장_큰_수();
        a.solution(new int[]{6,10,2});
        a.solution(new int[]{3,30,34,5,9});
        a.solution(new int[]{7,9});
        a.solution(new int[]{70, 7, 76});
        a.solution(new int[]{7, 79, 779});
        a.solution(new int[]{7, 76, 78, 77});
        a.solution(new int[]{1,0,0,10});
        a.solution(new int[]{0,10,100,1000,101});
        a.solution(new int[]{1000, 111, 110, 101, 100, 11, 10, 1, 0});
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        answer = sb.toString();

        if (answer.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    /**
     * 9 : 7 = 9
     * 5 : 11 = 5
     * 55 : 39 = 55
     * 85 : 0 = 85
     * 77 : 779 = 77977 77779
     * 99 : 997 = 99997 99799
     * 292 : 2 = 2922
     * 212 : 2 = 2212
     * 7 : (779) = 7797
     * 7 79 779 = 79 779 7
     * 7 76 78 77 = 7877776
     */
}
