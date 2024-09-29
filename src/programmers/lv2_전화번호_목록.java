package programmers;

import java.util.Arrays;

public class lv2_전화번호_목록 {

    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            if (a.length() > b.length()) {
                continue;
            } else {
                b = b.substring(0, a.length());
            }
            if (a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
