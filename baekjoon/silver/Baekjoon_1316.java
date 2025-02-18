package baekjoon.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/***
 * 그룹 단어 체커
 */
public class Baekjoon_1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (isGroupWord(s)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isGroupWord(String s) {
        Set<Character> set = new HashSet<>();
        char prev = s.charAt(0);
        set.add(prev);
        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now != prev && set.contains(now)) { // 이전에 나온 문자가 떨어져서 다시 등장
                return false;
            }
            set.add(now);
            prev = now;
        }
        return true;
    }
}
