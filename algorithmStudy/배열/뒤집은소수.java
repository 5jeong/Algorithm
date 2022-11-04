package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 뒤집은소수 {
    public static boolean isPirme(int num){
        if(num==1) return false;
        for(int i=2;i<num;i++){
            if(num%i==0){
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
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            int tmp = arr[i];
            int res =0;
            while(tmp>0){
                int t = tmp%10;
                res = res*10 +t;
                tmp /=10;
            }
            if(isPirme(res)==true){
                ans.add(res);
            }
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
