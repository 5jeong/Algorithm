package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

// 카드팩 구매하기
public class Baekjoon_15823 {
    static int n, m;
    static int[] cards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int lt = 0;
        int rt = n / m;
        int mid = 0;
        int ans = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (isPossible(mid)) {
                ans = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(ans);
    }

    // mid 수 만큼 m개로 짜르는게 가능한지 여부
    // 중복된 수 없어야함.
    // 투포인터
    static boolean isPossible(int mid) {
        int cnt = 0;
        int[] ch = new int[500001];
        Arrays.fill(ch, -1);
        for (int start = 0, end = 0; end < n; end++) {
            // 중복인 경우
            if (ch[cards[end]] >= start) {
                start = ch[cards[end]] + 1;
            }
            ch[cards[end]] = end;
            if (end - start + 1 >= mid) {
                cnt++;
                start = end + 1;
            }
            if (cnt == m) {
                return true;
            }
        }
        return false;
    }
}
