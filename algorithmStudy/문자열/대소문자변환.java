package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 대소문자변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
        for(char x : str.toCharArray()){
            if(Character.isUpperCase(x)){
                ans+= Character.toLowerCase(x);
            }
            if(Character.isLowerCase(x)){
                ans+= Character.toUpperCase(x);
            }
        }
        System.out.println(ans);
    }
}
