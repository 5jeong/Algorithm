package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//에라토스테네스 체
public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int ans =0;
        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                ans++;
            }
            for(int j=i;j<=n;j+=i){
                arr[j] = 1;
            }
        }
        System.out.println(ans);

    }
}
