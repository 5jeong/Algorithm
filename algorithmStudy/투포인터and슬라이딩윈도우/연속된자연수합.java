package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n/2+1];
        int ans=0;
        int sum=0;
//        for(int i=0;i<arr.length;i++){
//            arr[i] = i+1;
//        }
//        int lp=0;
//        for(int rp=0;rp<arr.length;rp++){
//            sum+=arr[rp];
//            while (sum > n) {
//                sum -= arr[lp];
//                lp++;
//            }
//            if(sum==n){
//                ans++;
//            }
//        }
        //수학적 풀이
        int cnt=1;
        n--;
        while(n>0){
            cnt++;
            n-=cnt;
            if(n%cnt==0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
