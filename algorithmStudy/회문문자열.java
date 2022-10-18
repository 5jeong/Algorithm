package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        int lt = 0, rt = str.length() - 1;
        while(lt < rt){
            if(str.charAt(lt) == str.charAt(rt)){
                lt++;
                rt--;
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
