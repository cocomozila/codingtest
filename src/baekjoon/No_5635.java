package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class No_5635 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Person youngest = null;
        Person oldest = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Person person = new Person(name, LocalDate.of(year, month, day));

            if (oldest == null || person.birthDate.isBefore(oldest.birthDate)) {
                oldest = person;
            }
            if (youngest == null || person.birthDate.isAfter(youngest.birthDate)) {
                youngest = person;
            }
        }

        sb.append(youngest.name).append("\n").append(oldest.name);
        System.out.println(sb.toString());
    }

    static class Person {
        String name;
        LocalDate birthDate;

        public Person(String name, LocalDate birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }
    }
}
