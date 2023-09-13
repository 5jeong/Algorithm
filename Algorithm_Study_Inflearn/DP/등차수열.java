package Algorithm_Study_Inflearn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등차수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int ans =0;
        int[][] dp = new int[n+1][n+1];
        int[] nums = new int[n+1];
        for(int i=1;i<=n;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                dp[i][j] =2;
                int c = nums[j] - nums[i]; // 공차
                int pre = nums[i] - c;
                int k=0;
                for(k = i-1;k>0;k--){
                    if(nums[k] == pre) break;
                }
                dp[i][j] = Math.max(dp[i][j],dp[k][i]+1);
                ans = Math.max(ans,dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}