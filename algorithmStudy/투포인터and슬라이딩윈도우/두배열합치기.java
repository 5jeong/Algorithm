package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int p1=0,p2=0;
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int arr2[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //투포인터 알고리즘
        while(p1 <n && p2<m){
            if(arr[p1]<arr2[p2]){
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

//        for(int i =0;i<n;i++){
//            ans.add(arr[i]);
//        }
//        for(int i=0;i<m;i++) {
//            ans.add(arr2[i]);
//        }
//        Collections.sort(ans);
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
