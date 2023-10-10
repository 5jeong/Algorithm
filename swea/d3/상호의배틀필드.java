package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 상호의배틀필드 {

    static char[][] board;
    static int h, w,x,y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void up(char[][] board, int x1, int y1) {

        int nx = x1 + dx[0];
        int ny = y1 + dy[0];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == '.') {
            board[x1][y1] = '.';
            board[nx][ny] = '^';
            x=nx;
            y=ny;
        }
        else{
            board[x1][y1]='^';
        }
    }

    static void down(char[][] board, int x1, int y1) {
        int nx = x1 + dx[1];
        int ny = y1 + dy[1];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == '.') {
            board[x1][y1] = '.';
            board[nx][ny] ='v';
            x=nx;
            y=ny;
        }
        else{
            board[x1][y1]='v';
        }
    }

    static void left(char[][] board, int x1, int y1) {
        int nx = x1 + dx[2];
        int ny = y1 + dy[2];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == '.') {
            board[x1][y1] = '.';
            board[nx][ny] = '<';
            x=nx;
            y=ny;
        }
        else{
            board[x1][y1]='<';
        }
    }

    static void right(char[][] board, int x1, int y1) {
        int nx = x1 + dx[3];
        int ny = y1 + dy[3];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == '.') {
            board[x1][y1] = '.';
            board[nx][ny] = '>';
            x=nx;
            y=ny;
        }
        else{
            board[x1][y1]='>';
        }

    }

    static void shoot(char[][] board, int x1, int y1) {
        char c = board[x1][y1];
        int nx = x1;
        int ny = y1;
        if (c == '^') {
            for (int i = 0; i < h; i++) {
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#') break;
                if (board[nx][ny] == '*') {
                    board[nx][ny] = '.';
                    break;
                }
                nx += dx[0];
                ny += dy[0];
            }
        }
        if (c == 'v') {
            for (int i = 0; i < h; i++) {
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#') break;
                if (board[nx][ny] == '*') {
                    board[nx][ny] = '.';
                    break;
                }
                nx += dx[1];
                ny += dy[1];
            }
        }
        if (c == '<') {
            for (int i = 0; i < w; i++) {
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#') break;
                if (board[nx][ny] == '*') {
                    board[nx][ny] = '.';
                    break;

                }
                nx += dx[2];
                ny += dy[2];
            }
        }
        if (c == '>') {
            for (int i = 0; i < w; i++) {
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#') break;
                if (board[nx][ny] == '*') {
                    board[nx][ny] = '.';
                    break;

                }
                nx += dx[3];
                ny += dy[3];
            }
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            h = sc.nextInt();
            w = sc.nextInt();
            board = new char[h][w];
            x = 0;
            y = 0;
            for (int i = 0; i < h; i++) {
                String str = sc.next();
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '^' || str.charAt(j) == 'v' || str.charAt(j) == '<' || str.charAt(j) == '>') {
                        x = i;
                        y = j;
                    }
                    board[i][j] = str.charAt(j);
                }
            }
            int n = sc.nextInt();
            String s = sc.next();
            for (char motion : s.toCharArray()) {
                if(motion=='S'){
                    shoot(board,x,y);
                }
                if(motion=='U'){
                    up(board,x,y);
                }
                if(motion=='D'){
                    down(board,x,y);
                }
                if(motion=='L'){
                    left(board,x,y);
                }
                if(motion=='R'){
                    right(board,x,y);
                }
            }
            System.out.print("#"+test_case+" " );
            for (char[] a : board) {
                for (char b : a) {
                    System.out.print(b);
                }
                System.out.println();
            }
        }
    }
}