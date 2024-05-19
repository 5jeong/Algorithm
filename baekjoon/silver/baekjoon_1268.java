package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][5];
        int[] ch;
        ArrayList<Integer> temp = new ArrayList<>();
        int ans=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++) {
            int cnt = 0;
            ch = new int[n];
            for (int j = 0; j < 5; j++) {
                for(int s=0;s<n;s++){
                    if(i==s){
                        continue;
                    }
                    if(arr[i][j]==arr[s][j] && ch[s]==0){
                        ch[s] = 1;
                        cnt++;
                    }
                }
            }
            temp.add(cnt);
        }
        int k=Integer.MIN_VALUE;
        for(int i=0;i<temp.size();i++){
            if(k < temp.get(i)){
                k = temp.get(i);
                ans=i+1;
            }
        }
        System.out.println(ans);
    }
}
