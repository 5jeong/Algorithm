package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 숫자배열회전 {

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int[][] arr2 = new int[n][n];
            int[][] arr3 = new int[n][n];
            int[][] arr4 = new int[n][n];
            int t = n-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr2[j][t] = arr[i][j];
                }
                t--;
            }
            t = n-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr3[j][t] = arr2[i][j];
                }
                t--;
            }
            t = n-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr4[j][t] = arr3[i][j];
                }
                t--;
            }

            System.out.println("#"+test_case);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr2[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<n;j++){
                    System.out.print(arr3[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<n;j++){
                    System.out.print(arr4[i][j]);
                }
                System.out.println();
            }
        }
    }
}
