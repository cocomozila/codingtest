package programmers.kakao.winter2024;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장_많이_받은_선물 {

    public static void main(String[] args) {
        가장_많이_받은_선물 a = new 가장_많이_받은_선물();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(a.solution(friends, gifts));
    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendsToNumber = new HashMap<>();
        Map<Integer, String> NumberToFriends = new HashMap<>();
        Map<String, Integer> given = new HashMap<>();
        Map<String, Integer> received = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();
        int count = 0;
        for (String friend : friends) {
            friendsToNumber.put(friend, count);
            NumberToFriends.put(count, friend);
            given.put(friend, 0);
            received.put(friend, 0);
            score.put(friend, 0);
            count += 1;
        }

        int[][] board = new int[friends.length][friends.length];
        for (String s : gifts) {
            StringTokenizer st = new StringTokenizer(s, " ");
            String friend1 = st.nextToken();
            String friend2 = st.nextToken();

            int f1 = friendsToNumber.get(friend1);
            int f2 = friendsToNumber.get(friend2);
            given.put(friend1, given.get(friend1) + 1);
            received.put(friend2, received.get(friend2) + 1);

            board[f1][f2] = board[f1][f2] + 1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board[0].length; j++) {
                if (i == j) {
                    continue;
                }
                String friend1 = NumberToFriends.get(i);
                String friend2 = NumberToFriends.get(j);
                if (board[i][j] < board[j][i]) {
                    score.put(friend2, score.get(friend2) + 1);
                } else if (board[i][j] == board[j][i]) {
                    int friend1Score = given.get(friend1) - received.get(friend1);
                    int friend2Score = given.get(friend2) - received.get(friend2);
                    if (friend1Score > friend2Score) {
                        score.put(friend1, score.get(friend1) + 1);
                    } else if (friend1Score < friend2Score) {
                        score.put(friend2, score.get(friend2) + 1);
                    }
                } else {
                    score.put(friend1, score.get(friend1) + 1);
                }
            }
        }

        return score.values().stream().max(Integer::compareTo).orElse(0);
    }

}
