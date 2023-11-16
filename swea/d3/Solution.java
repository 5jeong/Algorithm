package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = i - 2; j <= i + 2; j++) {
                    if (i == j) continue;
                    max = Math.max(max, arr[j]);
                }
                if (arr[i] - max < 0) continue;
                ans += arr[i] - max;
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
