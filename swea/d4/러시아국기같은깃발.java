package swea.d4;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
2
4 5
WRWRW
BWRWB
WRWRW
RWBWR
 */
public class 러시아국기같은깃발 {
    static int n,m;
    static char[][] arr;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr= new char[n][m];
            for(int i=0;i<n;i++){
                String str = sc.next();
                for(int j=0;j<m;j++){
                    arr[i][j] = str.charAt(j);
                }
            }
            int ans=0;
            //첫위칸은 빨, 파 갯수로 ans저장 , 마지막칸은 흰,파 갯수 저장
            for(int i=0;i<m;i++){
                if(arr[0][i]=='R' || arr[0][i]=='B'){
                    arr[0][i]='W';
                    ans++;
                }
                if(arr[n-1][i]=='W' || arr[n-1][i]=='B'){
                    arr[n-1][i] = 'R';
                    ans++;
                }
            }
            for(int i=1;i<n-2;i++){
                for(int j=i;j<=n-2;j++){
                    for(int k=j+1;k<=n-2;k++){

                    }
                }
            }
        }
    }
}
