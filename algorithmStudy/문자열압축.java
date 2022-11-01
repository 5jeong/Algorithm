package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str +=" ";
        int cnt=1;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                cnt++;
            }
            else{
                if(cnt==1){
                    System.out.print(str.charAt(i));
                }
                else{
                    System.out.print(str.charAt(i));
                    System.out.print(cnt);
                    cnt=1;
                }
            }
        }
    }
}
