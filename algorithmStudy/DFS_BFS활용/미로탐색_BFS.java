package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로탐색_BFS {
    static class Point{
        public int x,y;
        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] dis = new int[8][8];
    static int[][] board = new int[8][8];

    static void BFS(int x,int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int dir = 0 ; dir<4;dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx>=1 && nx <=7 && ny >=1 && ny <=7 && board[nx][ny]==0){
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[p.x][p.y]+1;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=1;i<=7;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=7;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(1,1);
        if(dis[7][7] == 0){
            System.out.println("-1");;
        }
        else{
            System.out.println(dis[7][7]);
        }
    }
}
