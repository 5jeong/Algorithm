package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 준환이의운동관리 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int l = sc.nextInt();
            int u = sc.nextInt();
            int x = sc.nextInt();
            int ans=0;
            if(x<l){
                ans = l-x;
            }
            if(x > u){
                ans= -1;
            }
            if( x >l && x < u){
                ans =0;
            }
            System.out.println("#"+test_case+" "+ans);


        }
    }
}