package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 알파벳공부 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        T = 10;

        String res = "abcdefghijklmnopqrstuvwxyz";
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            int ans=0;
            for(int i=0;i<res.length();i++){
                if(i == str.length() || res.charAt(i) !=str.charAt(i)) break;
                if(res.charAt(i) == str.charAt(i)){
                    ans++;
                }
            }
            System.out.println("#"+test_case+" "+ans);

        }
    }
}
