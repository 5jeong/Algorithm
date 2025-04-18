package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 거짓말
public class Baekjoon_1043 {
    static int[] unf;
    static List<List<Integer>> parties;
    static List<Integer> truePersons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람수
        int m = sc.nextInt(); // 파티수
        int trueCnt = sc.nextInt(); // 진실 아는 사람수
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        truePersons = new ArrayList<>();
        for (int i = 0; i < trueCnt; i++) {
            truePersons.add(sc.nextInt());
        }

        parties = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            parties.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int a = sc.nextInt();
                parties.get(i).add(a);
            }
        }
        // 파티 구성원 끼리 다묶기.
        for (List<Integer> party : parties) {
            for (int i = 1; i < party.size(); i++) {
                union(party.get(0), party.get(i));
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (isPossible(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int num) {
        for (int x : parties.get(num)) {
            for (int truePerson : truePersons) {
                if (find(truePerson) == find(x)) {
                    return false;
                }
            }
        }
        return true;
    }

    static int find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fb] = fa;
        }
    }
}
