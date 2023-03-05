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
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int lt=0,rt=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (lt < n && rt < m) {
            if (arr[lt] == arr2[rt]) {
                ans.add(arr[lt]);
                lt++;
                rt++;
            }
            else if(arr[lt] < arr2[rt]){
                lt++;
            }
            else{
                rt++;
            }
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
