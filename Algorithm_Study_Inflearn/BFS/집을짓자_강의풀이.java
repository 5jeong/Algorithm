package Algorithm_Study_Inflearn.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 집을짓자_강의풀이 {
    static int answer,n,emptyLand;
    static int[][]ch;
    static Queue<Point> queue;
    static int[][] dis;
    static int[] dx ={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int BFS(int[][] board){
        int L=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            L++;
            for(int i=0;i<len;i++){
                Point temp = queue.poll();
                for(int j=0;j<4;j++){
                    int nx = temp.x+dx[j];
                    int ny = temp.y+dy[j];
                    if(nx>=0 && nx <n && ny>=0 && ny<n && board[nx][ny] == emptyLand){
                        dis[nx][ny] +=L;
                        board[nx][ny]--;
                        queue.offer(new Point(nx,ny));
                        answer = Math.min(answer, dis[nx][ny]);
                    }
                }
            }
        }
        emptyLand--;
        return answer;

    }
    public static int solution(int[][] board){
        n=board.length;
        queue = new LinkedList<>();
        dis = new int[n][n];
        int res=0;
        emptyLand=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    queue.offer(new Point(i,j));
                    answer = Integer.MAX_VALUE;
                    int t = BFS(board);
                }
            }
        }
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
