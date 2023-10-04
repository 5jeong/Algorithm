package swea.d3;

import java.io.FileInputStream;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 수의새로운연산 {

    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
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
            int p = sc.nextInt();
            int q = sc.nextInt();
            int n=301;
            int[][] arr = new int[n][n];
            int cnt=1;
            int t=1;
            for(int i=1;i<n;i++){
                arr[i][1] =cnt;
                t++;
                cnt +=t;
            }
            for(int i=1;i<n;i++){
                int temp=i;
                for(int j=2;j<n-1;j++){
                    arr[i][j] = arr[i][j-1] + temp;
                    temp++;
                }
            }
            Point point1 = null;
            Point point2 = null;
            for(int i=1;i<n;i++){
                for(int j=1;j<n;j++){
                    if(arr[i][j] == p){
                        point1 = new Point(i,j);
                    }
                    if(arr[i][j] ==q){
                        point2 = new Point(i,j);
                    }
                }
            }
            int nx = point1.x + point2.x;
            int ny = point1.y+ point2.y;
            Point res = new Point(nx,ny);

            int ans = arr[res.x][res.y];
            System.out.println("#"+test_case+" "+ ans);



        }
    }
}
