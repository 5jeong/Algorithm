package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static boolean isPirme(int n){
        for(int i =2 ; i<n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0 ;
            while(temp>0){
                int t = temp % 10;
                res = res *10 +t;
                temp = temp/10;
            }
            if(isPirme(res)==true && res !=1){
                ans.add(res);
            }
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
