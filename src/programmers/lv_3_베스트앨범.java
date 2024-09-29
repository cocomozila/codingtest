package programmers;

import java.util.*;

public class lv_3_베스트앨범 {

    public static void main(String[] args) {

        lv_3_베스트앨범 a = new lv_3_베스트앨범();
        String[] g1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] p1 = {500, 600, 150, 800, 2500};

        int[] solution = a.solution(g1, p1);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 집계하기
        Map<String, Genre> genreGroup = new HashMap<>();
        Map<String, Album> albums = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (!genreGroup.containsKey(genre)) {
                genreGroup.put(genre, new Genre(genre, play));
            } else {
                genreGroup.get(genre).plusTotalPlay(play);
            }

            if (!albums.containsKey(genre)) {
                albums.put(genre, new Album());
                Album album = albums.get(genre);
                album.add(new Music(i, play));
            } else {
                albums.get(genre).add(new Music(i, play));
            }
        }
        GenreCounter group = new GenreCounter(genreGroup);

        ArrayList<Integer> list = new ArrayList<>();

        while (!group.genres.isEmpty()) {
            Genre pollGenre = group.genres.poll();
            Album album = albums.get(pollGenre.name);

            int count = 0;
            while (!album.queue.isEmpty() && count < 2) {
                Music poll = album.queue.poll();
                list.add(poll.number);
                count += 1;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static class GenreCounter {
        public PriorityQueue<Genre> genres = new PriorityQueue<>(Collections.reverseOrder());

        public GenreCounter(Map<String, Genre> genres) {
            Set<String> genreSet = genres.keySet();
            for (String genre : genreSet) {
                this.genres.add(genres.get(genre));
            }
        }

        public void add(Genre genre) {
            genres.add(genre);
        }
    }

    static class Genre implements Comparable<Genre> {
        public String name;
        public int totalPlays;

        public Genre(String name, int totalPlays) {
            this.name = name;
            this.totalPlays = totalPlays;
        }

        public void plusTotalPlay(int plays) {
            this.totalPlays += plays;
        }

        @Override
        public int compareTo(Genre o) {
            return this.totalPlays - o.totalPlays;
        }
    }

    // 같은 장르의 노래만 묶어놓은 클래스
    static class Album {
        PriorityQueue<Music> queue = new PriorityQueue<>(Collections.reverseOrder());

        public Album() {}

        public void add(Music music) {
            queue.add(music);
        }
    }

    // 고유 번호와 재생 횟수 클래스
    static class Music implements Comparable<Music> {
        int number;
        int play;

        public Music(int number, int play) {
            this.number = number;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            return this.play - o.play;
        }
    }
}
