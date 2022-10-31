package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효한팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String temp="";
        str = str.toUpperCase();
        for(char x : str.toCharArray()){
            if(Character.isAlphabetic(x)){
                temp += String.valueOf(x);
            }
        }
        for(int i=0;i<temp.length()/2;i++){
            if(temp.charAt(i)!=temp.charAt(temp.length()-i-1)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
