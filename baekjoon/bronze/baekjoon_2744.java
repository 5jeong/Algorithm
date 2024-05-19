package baekjoon.bronze;

import java.util.Scanner;

public class baekjoon_2744 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        for(char x : str.toCharArray()){
            if(x>=97 && x<=122){
                ans += (char)(x-32);
            }
            else if(x>=65 && x<=90){
                ans += (char)(x+32);
            }
        }
        System.out.println(ans);
    }

}
