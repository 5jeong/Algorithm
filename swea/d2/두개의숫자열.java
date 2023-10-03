package swea.d2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 두개의숫자열 {
    public static void main(String args[]) throws Exception
    {

//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            int len = Math.abs(n - m) + 1;
            int ans = Integer.MIN_VALUE;

            if(n<m){
                for (int i = 0; i < len; i++) {
                    int temp = 0;
                    for (int j = 0; j < n; j++) {
                        temp += a[j] * b[j+i];
                    }
                    ans = Math.max(ans, temp);
                }
            }
            else{
                for (int i = 0; i < len; i++) {
                    int temp = 0;
                    for (int j = 0; j < m; j++) {
                        temp += a[j+i] * b[j];
                    }
                    ans = Math.max(ans, temp);
                }
            }
            System.out.println("#"+test_case+" " + ans);
        }
    }
}
