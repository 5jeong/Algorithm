package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 상원이의연속합 {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = i + 1;
            }

            int lt = 0;
            int sum=0,ans=0;
            for(int rt =0;rt<n;rt++){
                sum+=arr[rt];
                while(sum > n){
                    sum-=arr[lt];
                    lt++;
                }
                if(sum == n){
                    ans++;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}