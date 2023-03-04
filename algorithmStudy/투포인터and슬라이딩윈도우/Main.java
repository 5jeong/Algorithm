package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int p1=0,p2=0;
        while(p1 < n && p2 < m){
            if(arr[p1] < arr2[p2]){
                ans.add(arr[p1]);
                p1++;
            }
            else{
                ans.add(arr2[p2]);
                p2++;
            }
        }
        while(p1<n){
            ans.add(arr[p1]);
            p1++;
        }
        while(p2<m){
            ans.add(arr2[p2]);
            p2++;
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
