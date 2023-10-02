package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 원재의메모리복구하기 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            int len = str.length();
            String temp = "";
            for(int i=0;i<len;i++){
                temp+="0";
            }
            int ans=0;
            char before = '0';
            for(int i=0;i<len;i++){
                if(before != str.charAt(i)){
                    before = str.charAt(i);
                    ans++;
                }
            }
            System.out.println("#"+test_case+" "+ ans);
        }
    }
}
