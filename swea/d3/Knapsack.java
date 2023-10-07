package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Knapsack {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] dp = new int[k+1];
            for(int i=0;i<n;i++){
                int v = sc.nextInt();
                int c = sc.nextInt();
                for(int j=k;j>=v;j--){
                    dp[j] = Math.max(dp[j],dp[j-v]+c);
                }
            }
            System.out.println("#"+test_case+" "+dp[k]);

        }
    }
}