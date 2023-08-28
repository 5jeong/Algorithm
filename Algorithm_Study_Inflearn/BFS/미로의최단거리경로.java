package Algorithm_Study_Inflearn.BFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리경로 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] dis;
    static int ans;
    static Queue<Point> queue;
    static class Point {
        int x;
        int y;
        Point(int x,int y){
            this.x =x;
            this.y= y;
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
                    int nx = temp.x+dx[j];
                    int ny = temp.y+dy[j];
                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        board[nx][ny] = 1;
                        dis[nx][ny] = L;
                    }
                }
            }
        }

    }
    public static int solution(int[][] board){
        ans = 0;
        dis= new int[7][7];
        queue=new LinkedList<>();
        queue.add(new Point(0,0));
        board[0][0]=1;
        BFS(board);
        ans=dis[6][6];
        if(ans==0){
            return -1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(solution(arr));
    }
}

