package swea.d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class 격자판칠하기 {


    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] board= new char[n][m];

            for(int i=0;i<n;i++) {
                String str = sc.next();
                for (int j = 0; j < m; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (board[i][j] == '?') {
                        for(int dir=0;dir<4;dir++){
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if(nx <0 || ny <0 || nx >=n || ny >=m ) continue;
                            if(board[nx][ny]=='.'){
                                board[i][j] = '#';
                            }
                            if(board[nx][ny]=='#'){
                                board[i][j] ='.';
                            }
                        }
                    }
                }
            }

            String ans = "possible";

            for(int i=0;i<n;i++){
                for(int j=0;j<m-1;j++){
                    if(board[i][j]=='?') continue;
                    if(board[i][j] == board[i][j+1]){
                        ans = "impossible";
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n-1;j++){
                    if(board[j][i]=='?') continue;
                    if(board[j][i] == board[j+1][i]){
                        ans = "impossible";
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
