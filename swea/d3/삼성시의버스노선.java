package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 삼성시의버스노선 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[5001];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                for (int j = a; j <= b; j++) {
                    arr[j] += 1;
                }
            }
            int p = sc.nextInt();
            int[] ans = new int[p];
            for (int i = 0; i < p; i++) {
                int temp = sc.nextInt();
                ans[i] = arr[temp];
            }
            System.out.print("#" + test_case + " ");
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();

        }
    }
}
