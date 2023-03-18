package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] arr;
    static int count(int num){
        int cnt=1;
        int sum=0;
        for(int x : arr){
            sum+=x;
            if(sum > num) {
                sum = x;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st= new StringTokenizer(br.readLine());
        int rt=0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            rt +=arr[i];
        }
        int lt = arr[arr.length-1];
        int mid=0,temp=0;
        while(lt <= rt){
            mid = (lt+rt)/2;
            if(count(mid) <= m ){
                temp = mid;
                rt=mid-1;
            }
            else{
                lt=mid+1;
            }

        }
        System.out.println(temp);
    }
}