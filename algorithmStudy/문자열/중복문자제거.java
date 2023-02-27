package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
//        System.out.println(str.indexOf('k',2));
        for(int i=0;i<str.length();i++){
            if( i == str.indexOf(str.charAt(i))){
                ans +=str.charAt(i);
            }
            else{
                continue;
            }
        }
        System.out.println(ans);
    }
}