package baekjoon;

import java.util.Scanner;

public class beakjoon_1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] countA = count(s1);
        int[] countB = count(s2);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                ans += Math.abs(countA[i] - countB[i]);
            }
        }
        System.out.println(ans);
    }

    private static int[] count(String s1) {
        int[] count = new int[26];
        for (char x : s1.toCharArray()) {
            count[x - 'a']++;
        }
        return count;
    }
}
