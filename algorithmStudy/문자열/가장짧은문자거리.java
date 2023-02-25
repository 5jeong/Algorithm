package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장짧은문자거리 {
   public static void main(String[] args) throws IOException {
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       String c = br.readLine();
       c = c.toUpperCase();
       str = str.toUpperCase();
       int ans=0;
       for(char x : str.toCharArray()){
           if(x == c.charAt(0)){
               ans++;
           }
       }
       System.out.println(ans);
   }
}
 

