package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dy = new int[n];
        int ans = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dy[0] = 1;
        for(int i=0;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(arr[i] >arr[j]){
                    temp = Math.max(temp,dy[j]);
                }
            }
            dy[i] = temp+1;
        }
        for(int x : dy){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}