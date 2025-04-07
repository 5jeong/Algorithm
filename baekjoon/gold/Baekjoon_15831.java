package baekjoon.gold;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 준표의 조약돌
public class Baekjoon_15831 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();

        String s = sc.next();
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('B',0);
        map.put('W',0);
        int ans = 0;
        for (int end = 0; end < n; end++) {
            char now = s.charAt(end);
            map.put(now, map.getOrDefault(s.charAt(end), 0) + 1);

            while (map.get('B') > b) {
                char startChar = s.charAt(start);
                start++;
                map.put(startChar, map.get(startChar) - 1);
            }
            if (map.get('W') >= w) {
                ans = Math.max(ans, end - start + 1);
            }
        }
        System.out.println(ans);
    }
}
