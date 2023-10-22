package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 최대성적표만들기 {

    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int k  = sc.nextInt();
            Integer[] score = new Integer[n];
            for(int i=0;i<n;i++){
                score[i]=sc.nextInt();
            }
            Arrays.sort(score, Collections.reverseOrder());
            int ans=0;
            for(int i=0;i<k;i++){
                ans+=score[i];
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
