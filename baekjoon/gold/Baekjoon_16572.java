package baekjoon.gold;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 고냥이
public class Baekjoon_16572 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            char now = s.charAt(end);
            map.put(now, map.getOrDefault(now, 0) + 1);

            while (map.size() > n) {
                char startChar = s.charAt(start);
                start++;
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        System.out.println(ans);

    }
}
