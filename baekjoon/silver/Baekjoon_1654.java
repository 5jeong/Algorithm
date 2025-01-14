package baekjoon.silver;

import java.util.Scanner;

/***
 * k개의 랜선으로 n개의 랜선을 만들수 있다.
 * n개보다 많이 만드는 것도 n개를 만든것에 포함
 *
 * max 값을 구해서 arr 생성
 * 이분탐색으로 랜선길이 값을 구해서, n개와 맞는지 비교
 * 최대 랜선길이를 구하기
 */
public class Baekjoon_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        long maxLen = 0;
        long[] lens = new long[k];
        int ans = 0;

        for (int i = 0; i < k; i++) {
            lens[i] = sc.nextInt();
            maxLen = Math.max(maxLen, lens[i]);
        }

        long lt = 1;
        long rt = maxLen;
        long mid = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int cnt = 0;
            for (long len : lens) {
                cnt += (int) (len / mid);
            }
            if (cnt < n) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                ans = (int) Math.max(ans, mid);
            }
        }
        System.out.println(ans);

    }
}
