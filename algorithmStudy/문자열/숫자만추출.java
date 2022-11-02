package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String temp="";
        int ans=0;
        int cnt=0;
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                temp+=x;
            }
        }
        ans = Integer.parseInt(temp); //문자열을 int형으로 변환
//        for(int i=0;i<temp.length();i++){
//            if(temp.charAt(i)!='0'){
//                for(int j=i;j<temp.length();j++){
//                    ans += temp.charAt(j);
//                }
//                break;
//            }
//        }
        System.out.println(ans);
    }
}