package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] res = new int[10];
        for (char x : s.toCharArray()) {
            int temp = Integer.parseInt(String.valueOf(x));
            res[temp]++;
        }

        int ans = 0;
        for(int i=0;i<10;i++){
            if(i==6 || i==9 ){
                continue;
            }
            ans = Math.max(ans,res[i]);
        }
        ans = Math.max(ans, (res[6] + res[9] + 1) / 2);

        System.out.println(ans);
    }
}
