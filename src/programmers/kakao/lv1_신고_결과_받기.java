package programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class lv1_신고_결과_받기 {

    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idToNumberMap = new HashMap<>();
        Map<Integer, String> numberToIdMap = new HashMap<>();
        int idCounter = 0;
        for (String id : id_list) {
            idToNumberMap.put(id, idCounter);
            numberToIdMap.put(idCounter, id);
            idCounter += 1;
        }

        ArrayList<Integer>[] reportList = new ArrayList[id_list.length];
        for (int i = 0; i < reportList.length; i++) {
            reportList[i] = new ArrayList<>();
        }

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String from = st.nextToken();
            String to = st.nextToken();
        }


        int[] answer = {};
        return answer;
    }
}
