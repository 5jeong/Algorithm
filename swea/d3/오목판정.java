package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 오목판정 {

    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,-1,1};
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] board = new char[n][n];
            for(int i=0;i<n;i++) {
                String str = sc.next();
                for (int j = 0; j < str.length(); j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            String ans = "NO";
            game:for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='o'){
                        int cnt=0;
                        for(int dir=0;dir<8;dir++){
                            int t=1;
                            int nx = i+ dx[dir];
                            int ny = j+ dy[dir];
                            while (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny]=='o'){
                                nx +=dx[dir];
                                ny+= dy[dir];
                                t++;
                            }
                            cnt=Math.max(cnt,t);
                            if(cnt>=5){
                                ans = "YES";
                                break game;
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" " +ans);
        }
    }
}
