package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//에라토스테네스 체
public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[] arr = new int[n+1];

        int cnt=0;
        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                arr[i]=1;
                cnt++;
                for(int j=i;j<=n;j+=i){
                    arr[j]=1;
                }
            }
        }
        System.out.println(cnt);
    }
}
