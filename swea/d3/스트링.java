package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 스트링 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            String check = sc.next();
            String str = sc.next();
            int len =check.length();
            int ans=0;

            for(int i=0;i<=str.length()-len;i++){
                String temp=str.substring(i,i+len);
                if(temp.equals(check)){
                    ans++;
                }
            }
            System.out.println("#"+n+" "+ans);

        }
    }
}
