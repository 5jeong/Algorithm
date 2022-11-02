package algorithmStudy.문자열;

import java.util.Scanner;

public class 문장속단어 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans ="";
        String[] s = str.split(" ");
        ans = s[0];
        for(int i=1;i<s.length;i++){
            if(ans.length()<s[i].length()){
                ans = s[i];
            }
        }
        System.out.println(ans);

    }
}
