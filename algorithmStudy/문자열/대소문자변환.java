package algorithmStudy.문자열;

import java.util.Scanner;

public class 대소문자변환 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String ans ="";
        for(char x : str.toCharArray()){

            if(Character.isLowerCase(x) ){
                ans += Character.toUpperCase(x);
            }
            else if(Character.isUpperCase(x)){
                ans += Character.toLowerCase(x);
            }
        }
        System.out.println(ans);
    }
}
