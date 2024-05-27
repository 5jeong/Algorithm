package baekjoon.bronze;

import java.util.Scanner;

public class Baekjoon_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];
        for (int i = 1; i <= 1000; i++) {
            arr[i] = i * (i + 1) / 2;
        }
        int k = 0;
        for (int t = 0; t < n; t++) {
            k = sc.nextInt();
            int ans = 0;
            game:
            for (int i = 1; i <= 1000; i++) {
                int sum = 0;
                for (int j = i; j <= 1000; j++) {
                    for (int s = j; s <= 1000; s++) {
                        sum = arr[i] + arr[j] + arr[s];
                        if (sum == k) {
                            ans = 1;
                            break game;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
