package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr =new int[15][15];
            for(int i=0;i<15;i++){
                arr[0][i]=i;
                arr[i][1] = 1;
            }
            for(int i = 1 ;i <=k;i++ ){
                for(int j=2;j<n+1;j++){
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
            System.out.println(arr[k][n]);
            arr = new int[15][15];
        }
    }
}
