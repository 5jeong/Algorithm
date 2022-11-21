package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int ans=Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-k+1;i++){
            int temp=0;
            for(int j=0;j<k;j++){
                temp += arr[j+i];
            }
            ans = Math.max(ans,temp);
        }
        System.out.println(ans);
    }
}
