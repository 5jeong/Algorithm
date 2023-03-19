package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] arr;
    static int c;
    static boolean check(int n){
        int cnt=1;
        int temp = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-temp >= n){
                cnt++;
                temp = arr[i];
            }
        }
        if(cnt >= c){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt =1;
        int rt =arr[n-1] - arr[0];
        int mid=0,ans=0;

        while(lt <= rt){
            mid = (lt+rt)/2;
            if(check(mid) == false){
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