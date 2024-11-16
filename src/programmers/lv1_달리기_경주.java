package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class lv1_달리기_경주 {

    public static void main(String[] args) {

    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];
            int rank = rankMap.get(calling);
            String target = players[rank - 1];
            players[rank - 1] = calling;
            players[rank] = target;
            rankMap.put(target, rank);
            rankMap.put(calling, rank - 1);
        }

        return players;
    }
}
