package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 격자판최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] arr = new int[n][n];
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int c=0;
        int d=0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < n; j++) {
                if(i==j){
                    c+=arr[i][j];
                }
                if(i+j==n-1){
                    d+=arr[i][j];
                }
                a += arr[i][j];
                b += arr[j][i];

            }
            temp.add(a);
            temp.add(b);
        }
        temp.add(c);
        temp.add(d);

        for (int x : temp) {
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}
