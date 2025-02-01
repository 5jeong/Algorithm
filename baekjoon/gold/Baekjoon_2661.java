package baekjoon.gold;

import java.util.Scanner;

/***
 * 좋은수열
 * 1,2,3으로 이루어진 수열
 * 인접한 두개의 부분 수열이 동일하면 나쁜 수열 ex) 33, 1212,3212132
 * 아니면 좋은수열
 */
public class Baekjoon_2661 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs("");
    }

    static void dfs(String ans) {
        if (ans.length() == n) {
            System.out.println(ans);
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (isGood(ans + i)) {
                    dfs(ans+i);
                }
            }
        }
    }

    // 좋은수열인지 판단
    static boolean isGood(String temp) {
        int n = temp.length();
        // idx로부터 판단
        for (int i = 1; i <= temp.length() / 2; i++) {
            String target1 = temp.substring(n - (i * 2), n - i);
            String target2 = temp.substring(n - i, n);
            if (target1.equals(target2)) {
                return false;
            }
        }
        return true;
    }
}
