package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 부분수열의합 {

    static int n,k,ans;
    static int[] num;
    static void dfs(int L,int sum){
        if(sum > k){
            return;
        }
        if(sum==k){
            ans++;
            return;
        }
        if(L==n){
            return;
        }
        else{
            dfs(L+1,sum+num[L]);
            dfs(L+1,sum);

        }

    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            ans=0;
            num = new int[n];
            for(int i=0;i<n;i++){
                num[i] = sc.nextInt();
            }
            dfs(0,0);
            System.out.println("#"+test_case + " " + ans);
        }
    }
}
