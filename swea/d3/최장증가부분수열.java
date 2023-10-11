package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 최장증가부분수열 {

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i]=sc.nextInt();
            }
            int[] dp = new int[n];
            Arrays.fill(dp,1);

            for(int i=1;i<n;i++){
                for(int j=i-1;j>=0;j--){
                    if(num[i] > num[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            int ans=0;
            for(int x : dp){
                ans=Math.max(ans,x);
            }
            System.out.println("#"+test_case+" "+ans);

        }
    }
}