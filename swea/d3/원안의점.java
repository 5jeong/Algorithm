package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 원안의점 {
    static int distance(int x,int y) {
        int dis = x*x + y*y;
        return dis;
    }
    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int ans=0;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    int temp =  distance(i,j);
                    if(temp > n*n) break;
                    if(temp <= n*n){
                        ans++;
                    }
                }
            }
            ans = (ans*4)+(n*4+1);
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
