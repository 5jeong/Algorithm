package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 거듭제곱 {

    static int n,m,ans;
    static void dfs(int L,int sum){
        if(L==m-1){
            ans = sum;
            return;
        }
        else{
            dfs(L+1,sum*=n);
        }
    }
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
        T=10;
        for(int test_case = 1; test_case <= T; test_case++) {
            int t =sc.nextInt();
            n = sc.nextInt();
            m =sc.nextInt();
            ans=0;
            dfs(0,n);

            System.out.println("#"+test_case+" " + ans);
        }
    }
}
