package Algorithm_Study_Inflearn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕가게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int)Math.round(Double.parseDouble(st.nextToken()) *100);
            if(n==0 && m==0) break;
            int[] dp =new int[m+1];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int)Math.round(Double.parseDouble(st.nextToken()) *100);
                for(int j=p;j<=m;j++){
                    dp[j] = Math.max(dp[j],dp[j-p]+c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}