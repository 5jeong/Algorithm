package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_10697 {
    static int n;
    static String s;
    static int[] ch;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        n = sc.nextLong();
        s = sc.next();
        // s의 길이가 9보다 작으면 1의 자리수로만 이루어져있고, 9보다 크면 10의자리 수도 포함.
        n = s.length() > 9 ? 9 + (s.length() - 9) / 2 : s.length();
        ch = new int[n + 1];
        dfs(0);
    }

    static void dfs(int idx) {

        if (idx == s.length()) {
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.exit(0);

        } else {
            // 1의 자리 체크
            int target1 = s.charAt(idx) - '0';
            if (ch[target1] == 0) {
                ch[target1] = 1;
                ans.add(target1);
                dfs(idx + 1);
                ch[target1] = 0;
                ans.remove(ans.size() - 1);
            }

            // idx + 1 이 수열 길이를 넘어가면 안됨
            if (idx + 1 >= s.length()) {
                return;
            }
            // 10의 자리 체크
            int target2 = target1 * 10 + (s.charAt(idx + 1) - '0');
            if (target2 <= n && ch[target2] == 0) {
                ch[target2] = 1;
                ans.add(target2);
                dfs(idx + 2);
                ch[target2] = 0;
                ans.remove(ans.size() - 1);
            }
        }
    }

}
