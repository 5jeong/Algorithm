package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 어디에단어가들어갈수있을까 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n+1][n+1];
            for(int i =0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans=0;
            for(int i =0;i<=n;i++){
                int cnt=0;
                int cnt2=0;
                for(int j=0;j<=n;j++){
                    if(arr[i][j]==1){
                        cnt++;
                    }
                    if(arr[i][j]==0 && cnt==k){
                        ans++;
                        cnt=0;
                    }
                    if(arr[i][j]==0 && cnt!=k){
                        cnt=0;
                    }
                    if(arr[j][i]==1){
                        cnt2++;
                    }
                    if(arr[j][i]==0 && cnt2==k){
                        ans++;
                        cnt2=0;
                    }
                    if(arr[j][i]==0 && cnt2!=k){
                        cnt2=0;
                    }
                }

            }
            System.out.println("#"+test_case+" " +ans);
        }
    }
}
