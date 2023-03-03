package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 격자판최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        ArrayList<Integer> temp = new ArrayList<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t =0;
        int k=0;
        for(int i=0;i<n;i++){
            int length=0;
            int width = 0;
            for(int j=0;j<n;j++){
                if(i==j){
                    t+=arr[i][j];
                }
                if(i+j==n-1){
                    k+=arr[i][j];
                }
                length+=arr[i][j];
                width+=arr[j][i];
            }
            temp.add(length);
            temp.add(width);
        }
        temp.add(t);
        temp.add(k);
        for(int x:temp){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}
