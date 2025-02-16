package baekjoon.gold;

import java.util.Scanner;

/***
 * 문자열 폭발
 */
public class Baekjoon_9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String bombStr = sc.next();
        int len = bombStr.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            sb.append(str.charAt(i));

            // 폭탄 문자열이 현재 넣는 문자열 기준으로 같으면 삭제
            if (sb.length() >= len && sb.substring(sb.length() - len).equals(bombStr)) {
                sb.delete(sb.length() - len, sb.length());
            }
        }
        System.out.println(sb.isEmpty() ? "FRULA" : sb.toString());
    }

}
