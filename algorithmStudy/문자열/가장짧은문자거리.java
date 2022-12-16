package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장짧은문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String t = st.nextToken();

        for(int i=0;i<str.length();i++){
            int ans=str.length();
            for(int j=0;j<str.length();j++){
                if (str.charAt(j) == t.charAt(0)) {
                    ans = Math.min(ans,Math.abs((i-j)));
                }
            }
            System.out.print(ans);
            System.out.print(" ");
        }
    }
}
 

