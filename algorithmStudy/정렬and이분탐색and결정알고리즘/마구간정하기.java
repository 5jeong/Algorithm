package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
///결정알고리즘 + 이분탐색
public class 마구간정하기 {
    public static int check(int[] arr,int n){
        int cnt =1;
        int idx=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] - idx >=n){
                cnt++;
                idx = arr[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans=0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = arr[1] - arr[0];
        int rt = arr[n-1];
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(check(arr,mid) < c ){
                rt = mid-1;
            }
            else{
                ans = mid;
                lt = mid+1;
            }
        }
        System.out.println(ans);
    }
}
