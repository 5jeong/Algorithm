package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int ans = 0;
        int[] arr = new int[n+2];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<n+2;i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        System.out.println(arr[n+1]);
    }
}
