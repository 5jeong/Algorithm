package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_7795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            int ans = 0;

            Arrays.sort(a);
            Arrays.sort(b);

            int j = 0;
            for (int i = 0; i < n; i++) {
                int temp = a[i];

                while (j < m && temp > b[j]) {
                    j++;
                }
                ans +=j;
            }
            System.out.println(ans);
        }
    }
}
