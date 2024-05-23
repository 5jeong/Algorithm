package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int x = sc.nextInt();
        int sum = 0;
        int ans = 0;
        int lt = 0;
        int rt = arr.length - 1;
        while (lt < rt) {
            sum = arr[lt] + arr[rt];
            if (sum == x) {
                ans++;
            }
            if (sum > x) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(ans);
    }
}
