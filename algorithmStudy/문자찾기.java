package algorithmStudy;

import java.util.Scanner;

public class 문자찾기 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        str =str.toUpperCase();
        c = Character.toUpperCase(c);
        int cnt=0;
        for(int i=0 ; i<str.length();i++){
            if(str.charAt(i)==c){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}


