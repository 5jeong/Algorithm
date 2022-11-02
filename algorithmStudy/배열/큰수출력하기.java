package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 큰수출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for(int i=0;i<n-1;i++) {
            if (arr[i] < arr[i + 1]) {
                ans.add(arr[i+1]);
            }
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
