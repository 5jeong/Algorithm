package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0;i<n;i++){
            String temp = str.substring(0,7).replace('#','1').replace('*','0');
            str = str.substring(7);
            int num = Integer.parseInt(temp,2);
            System.out.print((char)num);
        }
    }
}
