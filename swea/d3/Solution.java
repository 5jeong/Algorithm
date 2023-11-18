package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int T=10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] score = new int[n];
            int[] cal = new int[n];
            for(int i=0;i<n;i++){
                score[i]= sc.nextInt();
                cal[i] = sc.nextInt();
            }
            int[] dp = new int[l+1];
            for(int i=0;i<n;i++){
                for(int j=l;j>=cal[i];j--){
                    dp[j] = Math.max(dp[j],dp[j-cal[i]] + score[i]);
                }
            }
            System.out.println("#"+test_case+" "+dp[l]);
        }
    }
}

