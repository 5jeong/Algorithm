package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공통원소구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> ans = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int p1=0,p2=0;
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m= Integer.parseInt(br.readLine());
        int arr2[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        while(p1<n && p2<m){
            if (arr[p1] < arr2[p2]) {
                p1++;
            }
            else if(arr[p1]==arr2[p2]){
                ans.add(arr2[p2]);
                p1++;
                p2++;
            }
            else{
                p2++;
            }
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
