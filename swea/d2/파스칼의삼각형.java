package swea.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class 파스칼의삼각형 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                arr[i][0]=1;
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<n;j++){
                    if(arr[i-1][j-1] ==1 && arr[i-1][j] ==0){
                        arr[i][j] = 1;
                    }
                    if(arr[i-1][j-1] !=0 && arr[i-1][j] !=0){
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    }
                }
            }
            System.out.println("#"+test_case);
            for(int[] x : arr){
                for(int y : x){
                   if(y==0){
                       continue;
                   }
                    System.out.print(y+" ");
                }
                System.out.println();
            }
        }
    }
}
