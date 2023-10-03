package swea.d2;

import java.util.Scanner;
import java.io.FileInputStream;
class 파리퇴치
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans=0;
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
//            int k = n-m;
            for(int i=0;i<=n-m;i++){
                for(int j =0;j<=n-m;j++){
                    int temp=0;
                    for(int k =i;k<i+m;k++){
                        for(int l=j;l<j+m;l++){
                            temp+=arr[k][l];
                        }
                    }
                    ans = Math.max(ans,temp);
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}