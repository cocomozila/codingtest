package programmers;

import java.util.HashSet;
import java.util.Set;

public class lv1_폰켓몬 {

    public static void main(String[] args) {

    }

    public int solution(int[] nums) {
        int size = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(nums[i]);
        }

        if (set.size() >= size / 2) {
            return size / 2;
        }
        return set.size();
    }
}
