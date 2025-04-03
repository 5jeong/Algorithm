package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 접두사 찾기
public class Baekjoon_14426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> s = new ArrayList<>();
        List<String> targets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.next());
        }
        Collections.sort(s);
        for (int i = 0; i < m; i++) {
            targets.add(sc.next());
        }
        int ans = 0;
        for (String target : targets) {
            int lt = 0;
            int rt = n - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                String temp = s.get(mid).substring(0, target.length());
                int compare = temp.compareTo(target);
                if (compare == 0) {
                    ans++;
                    break;
                } else if (compare < 0) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        System.out.println(ans);

    }
}
