package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine() );
        int n = Integer.parseInt(st.nextToken());
        int[] arr =  new int[n];
        int[] dp = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[0]=1;
        int ans=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            int temp=1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    temp = Math.max(temp,dp[j]+1);
                }
            }
            dp[i] = temp;

        }
        for(int x : dp){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}
