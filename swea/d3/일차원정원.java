package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 일차원정원 {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n  = sc.nextInt();
            int d = sc.nextInt();
            int[] arr=  new int[d+1];
            arr[1] =3;
            for(int i=2;i<=d;i++){
                arr[i] = arr[i-1]+2;
            }
            int a = n/arr[d];
            int b = n % arr[d];
            int ans=0;
            if(b ==0){
                ans = a;
            }
            else{
                ans = a+1;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}