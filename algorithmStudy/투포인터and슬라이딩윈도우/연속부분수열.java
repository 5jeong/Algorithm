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
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt=0;
        int rt=0;
        int sum=0;
        while(rt<n){
            if(sum<m){
                sum += arr[rt];
                rt++;
            }
            if(sum>m){
                sum -= arr[lt];
                lt++;
            }
            if(sum==m){
                ans++;
                sum-=arr[lt];
                lt++;
            }
        }
//        for(int rt=lt;rt<n;rt++){
//            sum +=arr[rt];
//            while(sum > m){
//                sum-=arr[lt];
//                lt++;
//            }
//            if(sum == m){
//                ans++;
//            }
//
//        }
        System.out.println(ans);
    }
}
