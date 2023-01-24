package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//결정알고리즘
public class 뮤직비디오 {
    public static int count(int[] arr, int capacity){
        int cnt=1;
        int sum=0;
        for(int x : arr){
            if(sum+x > capacity){
                sum = x;
                cnt++;
            }
            else{
                sum+=x;

            }

        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int ans =0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)<=m){
                ans = mid;
                rt = mid-1;
            }
            else{
                lt = mid+1;
            }
        }
        System.out.println(ans);

    }

}
