package baekjoon.silver;

import java.util.Scanner;

/***
 * N일동안 자신이 사용할 금액 계산, M번만 통장에서 돈을 뻄
 * 매일 K원을 인출하며, 모자르면 남은금액을 통장에 넣고 다시 k원 인출
 * 최소값 lt = 1, rt = 총 금액의 합
 * 이분탐색
 *
 */
public class Baekjoon_6236 {
    static boolean isPossible(int mid, int[] costs, int m) {
        int cnt = 1; // 인출횟수
        int currentAmount = mid; // 현재금액
        for (int cost : costs) {
            // 못쓰면 금액 올려야함
            if (cost > mid) {
                return false;
            }
            if (currentAmount < cost) {

                cnt++;
                currentAmount = mid;
            }
            currentAmount -= cost;
        }
        // m보다 크면 금액 올려야함
        if (cnt > m) {
            return false;
        }
        // 금액 내려야함
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] costs = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
            sum += costs[i];
        }

        int ans = 0;
        int lt = 1;
        int rt = sum;

        // 이분탐색
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (isPossible(mid, costs, m)) {
                rt = mid - 1;
                ans = mid;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(ans);

    }
}
