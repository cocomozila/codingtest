package programmers;

import java.util.Arrays;

public class lv2_H_index {

    public static void main(String[] args) {
        lv2_H_index ob = new lv2_H_index();
        System.out.println(ob.solution(new int[]{3,0,6,1,5,0,0,0,0}));
        System.out.println(ob.solution(new int[]{0,0,0,0}));
        System.out.println(ob.solution(new int[]{5,5,5,5,5,5,5}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                max = Math.max(max, citations.length - i);
            }
        }
        return max;
    }

    // n개의 수 중 h 이상인 수 h개 이상 && 나머지 h이하 인 수
    // 3,0,6,1,5 = 0,1,3,5,6
    //             5,4,3,2,1
    // 9,9,9
    // 3,2,1
    // 0,0,1,2,3,4,5 = 2,2
    // 7,6,5,4,3,2,1
    // 1,1,1,1
    // 배열 정렬
    // if () {
    // }
}
