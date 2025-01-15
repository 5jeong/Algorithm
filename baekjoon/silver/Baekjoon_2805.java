package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2805 {
    static int n;
    static long m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 나무 수
        m = sc.nextLong(); // 집으로 가져가는 나무 길이
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        // 이분탐색
        binarySearch(tree);

    }

    private static void binarySearch(int[] tree) {
        long lt = 1;
        long rt = tree[n - 1];
        long ans=0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long h = 0;
            for (long x : tree) {
                long temp = x - mid;
                if (temp > 0) {
                    h += temp;
                }
            }
            if (h < m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                ans = Math.max(ans,mid);
            }
        }
        System.out.println(ans);
    }
}
