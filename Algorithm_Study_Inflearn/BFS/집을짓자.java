package Algorithm_Study_Inflearn.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 집을짓자 {
    static int answer,n;
    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static int[][]ch;
    static int[] dx ={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static Queue<Point> queue;
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int BFS(int[][] board){
        int[][] dis=new int[n][n];
        int L=0;
        while(!queue.isEmpty()){
            L++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0 && board[nx][ny]==1) {
                        ch[nx][ny]=1;
                        dis[nx][ny]=L;
                    }
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0 && board[nx][ny] ==0 ) {
                        dis[nx][ny] = L;
                        ch[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        int res=0;
        for(int i=0;i<x.size();i++){
            int t = dis[x.get(i)][y.get(i)];
            if(t==0){
                return -1;
            }
            else{
                res += t;
            }
        }

        return res;
    }
    public static int solution(int[][] board){
        n=board.length;
        queue = new LinkedList<>();
        answer = Integer.MAX_VALUE;
        int res=0;
        x = new ArrayList<>();
        y = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (board[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ch=new int[n][n];
                if(board[i][j]==0){
                    ch[i][j]=1;
                    queue.offer(new Point(i,j));
                    res = BFS(board);
                    if(res!=-1){
                        answer = Math.min(answer,res);
                    }
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
