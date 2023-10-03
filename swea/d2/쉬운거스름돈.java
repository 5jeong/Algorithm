package swea.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class 쉬운거스름돈 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] arr = {50000,10000,5000,1000,500,100,50,10};
        for(int test_case = 1; test_case <= T; test_case++) {
            int[] ans = new int[8];
            int n  =sc.nextInt();
            for(int i=0;i<arr.length;i++){
                if(arr[i] > n){
                    continue;
                }
                int cnt =  n / arr[i];
                ans[i] = cnt;
                n -= (arr[i] *cnt);

            }
            System.out.println("#"+test_case);
            for(int x : ans){
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }
}
