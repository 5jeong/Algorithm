package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// str.equalsIgnoreCase : 대소문자 구분 하지않고 문자열 비교

public class 회문문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
//        int lt = 0, rt = str.length() - 1;
//        while(lt < rt){
//            if(str.charAt(lt) == str.charAt(rt)){
//                lt++;
//                rt--;
//            }
//            else{
//                System.out.println("NO");
//                return;
//            }
//        }
//        System.out.println("YES");

//        for(int i=0;i<str.length()/2;i++){
//            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
//                System.out.println("NO");
//                return;
//            }
//        }
//        System.out.println("YES");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
