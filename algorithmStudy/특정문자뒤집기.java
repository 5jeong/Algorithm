package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정문자뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr= new String[1];
        String ans =" ";
        arr[0] = str;

        for(String x : arr){
            char[] s = x.toCharArray();
            System.out.println(s[0]);
            System.out.println(s[1]);

            int lt = 0, rt = s.length-1;

            while(lt<rt ){
                if(!Character.isAlphabetic(s[lt])){
                    lt++;
                }
                else if(!Character.isAlphabetic(s[rt])){
                    rt--;
                }
                else{
                    char tmp = s[lt];
                    s[lt] = s[rt];
                    s[rt] = tmp;
                    lt++;
                    rt--;
                }
            }

            ans = String.valueOf(s);
            System.out.println(ans);
        }
    }
}