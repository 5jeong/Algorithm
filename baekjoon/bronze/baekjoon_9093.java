package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for(int i=0;i<n;i++){
            str[i] = br.readLine();
        }
        for(int i=0;i<n;i++){
            String[] s = str[i].split(" ");
            StringBuilder ans = new StringBuilder();
            for(String x : s){
                StringBuilder sb = new StringBuilder(x);
                String a = sb.reverse().toString();
                ans.append(a);
                ans.append(" ");

            }
            System.out.println(ans);
        }
    }
}
  
 
