package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class N_Queen {
    static int ans;
    static int[] arr;
    static void dfs(int L,int n){
        if(L==n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            arr[L] = i;
            if(possibility(L)){
                dfs(L+1,n);
            }
        }
    }
    static boolean possibility(int col){
        for(int i=0;i<col;i++){
            if(arr[col] == arr[i]){
                return false;
            }
            else if(Math.abs(i-col) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            ans=0;
            int n = sc.nextInt();
            arr=new int[n];
            dfs(0,n);
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
