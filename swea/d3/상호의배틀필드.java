package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 상호의배틀필드 {

    static char[][] board;
    static int h,w;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static void up(char[][] board,int x,int y){
        int nx = x+dx[0];
        int ny = x+dy[0];
        char c = board[x][y];
        if(nx >=0 && nx < h && ny >=0&&ny<w && board[nx][ny]=='.'){
            board[x][y] = '.';
            board[nx][ny] = c;
        }
    }
    static void down(char[][] board,int x,int y){
        int nx = x+dx[1];
        int ny = x+dy[1];
        char c = board[x][y];
        if(nx >=0 && nx < h && ny >=0&&ny<w && board[nx][ny]=='.'){
            board[x][y] = '.';
            board[nx][ny] = c;
        }
    }
    static void left(char[][] board,int x,int y){
        int nx = x+dx[2];
        int ny = x+dy[2];
        char c = board[x][y];
        if(nx >=0 && nx < h && ny >=0&&ny<w && board[nx][ny]=='.'){
            board[x][y] = '.';
            board[nx][ny] = c;
        }
    }
    static void right(char[][] board,int x,int y){
        int nx = x+dx[3];
        int ny = x+dy[3];
        char c = board[x][y];
        if(nx >=0 && nx < h && ny >=0&&ny<w && board[nx][ny]=='.'){
            board[x][y] = '.';
            board[nx][ny] = c;
        }
    }
    static void shoot(char[][] board,int x,int y){
        char c = board[x][y];
        int nx = x;
        int ny = y;
        if(c=='^'){
            while(nx >=0 && nx < h && ny >=0 && ny<w && board[nx][ny]!='*'){
                board[nx][ny] = '.';
                nx += dx[0];
                ny += dy[0];
            }

        }
        if(c=='v'){

        }
        if(c=='<'){

        }
        if(c=='>'){

        }
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            h=sc.nextInt();
            w = sc.nextInt();
            board = new char[h][w];
            int x=0;
            int y=0;
            for(int i=0;i<h;i++){
                String str = sc.next();
                for(int j=0;j<str.length();j++){
                    if(str.charAt(j)=='^' ||str.charAt(j)=='v' || str.charAt(j)=='<' || str.charAt(j)=='>'  ){
                        x=i;
                        y=j;
                    }
                    board[i][j] = str.charAt(j);
                }
            }
            int n = sc.nextInt();
            String s = sc.next();
            for(char motion : s.toCharArray()){


            }


        }
    }
}