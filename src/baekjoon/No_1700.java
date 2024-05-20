package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int multitapSize = Integer.parseInt(st.nextToken());
        int caseNumber = Integer.parseInt(st.nextToken());

        boolean[] used = new boolean[101];
        int[] cases = new int[caseNumber];
        int run = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < caseNumber; i++) {
            cases[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < caseNumber; i++) {
            int num = cases[i];

            if (!used[num]) { // 플러그가 콘센트에 꽂혀있지 않을 때
                if (run < multitapSize) { // 멀티탭에 빈 자리가 있을 때
                    used[num] = true;
                    run += 1;
                } else { // 빈 자리 없을 때
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i; j < caseNumber; j++) { // 나올 플러그 순서 정리
                        if (used[cases[j]] && !list.contains(cases[j])) {
                            list.add(cases[j]);
                        }
                    }

                    if (list.size() != multitapSize) {
                        for (int j = 0; j < used.length; j++) {
                            if (used[j] && !list.contains(j)) {
                                used[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = list.get(list.size() - 1);
                        used[remove] = false;
                    }

                    used[num] = true;
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
