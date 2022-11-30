package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String str = br.readLine();
        char ans = '?';
        int[] cnt = new int[26];
        str = str.toUpperCase();
        for(char x : str.toCharArray() ){
            cnt[x-65]++;
        }
        boolean flag = false;
        int max = -1;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>max){
                max = cnt[i];
                ans = (char)(i+65);
            }
            else if (cnt[i]==max){
                ans = '?';
            }
        }
       
        System.out.println(ans);
    }
}
