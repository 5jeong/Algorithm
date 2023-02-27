package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String temp = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                temp += x;
            }
        }
        int ans = Integer.parseInt(temp);
        System.out.println(ans);
    }
}