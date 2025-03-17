package baekjoon.silver;

import java.util.Scanner;

// 펠린드롬 만들기
public class Baekjoon_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] alp = new int[26];

        for (char x : s.toCharArray()) {
            alp[x - 'A']++;
        }

        int cnt = 0;
        String start = "";
        String mid = "";
        String end = "";

        for (int i = 0; i < 26; i++) {
            if (alp[i] % 2 == 1) { // 홀수 체크
                mid = String.valueOf((char) (i + 'A'));
                cnt++;
            }
        }

        // 펠린드롬 못만들면 종료
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (alp[i] == 0 || alp[i] == 1) {
                continue;
            }
            // start
            for (int j = 0; j < alp[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        start = sb.toString();
        end = String.valueOf(sb.reverse());

        ans = start + mid + end;
        System.out.println(ans);

    }
}
