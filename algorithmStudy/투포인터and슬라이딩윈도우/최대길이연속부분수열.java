package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대길이연속부분수열 {
    public static void main(String[] main) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int ans=Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int cnt=0,len=0;
        int lt=0;
        for(int rt=0;rt<n;rt++){
            if(arr[rt]==0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            len = rt-lt+1;
            ans = Math.max(ans,len);
        }
        System.out.println(ans);

    }
}

