package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int sum=0;
        int ans =0;
        int[] arr =new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lp=0;
        for(int rp=0;rp<n;rp++){
            sum+=arr[rp];
            while(sum>m){
                sum-=arr[lp];
                lp++;
            }
            if(sum==m){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
