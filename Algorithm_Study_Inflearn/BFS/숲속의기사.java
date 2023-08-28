package Algorithm_Study_Inflearn.BFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class 숲속의기사 {
    static Queue<Point> queue;
    static int answer,r,c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dis;

    static int[][] ch;
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static void BFS(int[][] board){
        int L=0;
        while(!queue.isEmpty()){
            L++;
            int len = queue.size();
            for(int i=0;i<len;i++){
                Point temp = queue.poll();
                for(int j=0;j<4;j++){
                    int nx= temp.x +dx[j];
                    int ny = temp.y +dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] += L;
                    }
                }
            }
        }
    }

    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        queue = new LinkedList<>();
        r = board.length;
        c = board[0].length;
        dis = new int[r][c];
        ch = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    ch = new int[r][c];
                    ch[i][j] = 1;
                    queue.offer(new Point(i, j));
                    BFS(board);
                }
            }
        }
        int res=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j]==4){
                  res = dis[i][j];
                  answer = Math.min(answer,res);
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }

}
