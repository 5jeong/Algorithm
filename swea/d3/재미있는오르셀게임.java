package swea.d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class 재미있는오르셀게임 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,-1,1};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n+1][n+1];

            board[n/2][n/2] = 2;
            board[n/2][n/2 +1] = 1;
            board[n/2+1][n/2] = 1;
            board[n/2+1][n/2+1] = 2;

            for(int k=0;k<m;k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();

                board[x][y] = color;

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<1 || ny <1 || nx >n || ny >n){
                        continue;
                    }
                    if (board[nx][ny] != color && board[nx][ny] != 0 ) {
                        int cnt = 0;
                        while (nx>=0 && ny >=0 && nx <=n && ny <=n && board[nx][ny] != color  ) {
                            if(board[nx][ny]==0 ){
                                cnt=0;
                                break;
                            }
                            nx += dx[i];
                            ny += dy[i];
                            cnt++;
                        }
                        if(nx >n || ny > n){
                            cnt=0;
                        }
                        for (int j = 0; j < cnt; j++) {
                            nx -= dx[i];
                            ny -= dy[i];
                            board[nx][ny] = color;
                        }
                    }
                }
            }
            int black_cnt=0;
            int white_cnt=0;
            for (int[] a : board) {
                for (int b : a) {
                    if(b==1){
                        black_cnt++;
                    }
                    if(b==2){
                        white_cnt++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+black_cnt+" "+white_cnt);
        }
    }
}
