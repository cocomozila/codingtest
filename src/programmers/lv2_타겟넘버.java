package programmers;

public class lv2_타겟넘버 {

    static int[] arr = {0,1};
    static int[] staticNumbers;
    static int count = 0;
    static int targetCopy;

    public static void main(String[] args) {
        lv2_타겟넘버 a = new lv2_타겟넘버();
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(a.solution(arr, 3));
//        int[] arr2 = {4, 1, 2, 1};
//        System.out.println(a.solution(arr2, 4));
    }

    public int solution(int[] numbers, int target) {
        // 하나씩 배열에 받기
        staticNumbers = numbers;
        targetCopy = target;

        // DFS로 값 추적
        for (int i = 0; i < arr.length; i++) {
            DFS(0, 0, i);
        }

        // 정답
        return count;
    }

    public void DFS(int depth, int total, int doing) {
        int totalCopy = total;

        if (doing == 0) {
            totalCopy += staticNumbers[depth];
        } else {
            totalCopy -= staticNumbers[depth];
        }

        if (depth == staticNumbers.length - 1) {
            if (totalCopy == targetCopy) {
                count += 1;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            DFS(depth + 1, totalCopy, arr[i]);
        }
    }


}
