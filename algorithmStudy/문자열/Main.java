package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ans = new char[str.length()];

        int lt = 0;
        int rt = str.length() - 1;
        while (lt <= rt) {
            if(!Character.isAlphabetic(str.charAt(lt))){
                ans[lt] = str.charAt(lt);
                lt++;
            }
            else if(!Character.isAlphabetic(str.charAt(rt))){
                ans[rt] = str.charAt(rt);
                rt--;
            }
            else{
                ans[lt] = str.charAt(rt);
                ans[rt] = str.charAt(lt);
                lt++;
                rt--;
            }
        }
        for(char x : ans){
            System.out.print(x);
        }
    }
}
