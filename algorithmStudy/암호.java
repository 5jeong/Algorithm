package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int n = Integer.parseInt(a);

        String str = br.readLine();
        String ans = "";
        for(int i=0;i<n;i++){
            String tmp = str.substring(0,7).replace('#','1').replace('*','0');
            str = str.substring(7);
            int num = Integer.parseInt(tmp,2);
            ans += (char)num;
        }
        System.out.println(ans);
    }
}
