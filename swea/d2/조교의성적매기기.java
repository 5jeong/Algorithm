package swea.d2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 조교의성적매기기 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int total=0;
            String[] arr =  {"A+","A0","A-","B+","B0","B-", "C+","C0","C-","D0"};

            Integer[] score = new Integer[n];
            Integer[] temp = new Integer[n];
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                total = ( 35 * a ) + ( 45 * b )+ ( 20 * c );

                score[i] = total;
                temp[i] = total;
            }


            Arrays.sort(temp,Collections.reverseOrder());

            int res = score[k-1];

            int cnt=0;
            for(int i=0;i<n;i++){
                if(res == temp[i]){
                    cnt=i;
                    break;
                }
            }

            cnt = cnt / (n/10);
            String ans = arr[cnt];
            System.out.println("#"+test_case + " " + ans);
        }
    }
}
