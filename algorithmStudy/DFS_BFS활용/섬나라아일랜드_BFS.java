package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬나라아일랜드_BFS {
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] board ;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static int ans =0;

    static void BFS(int x,int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 8 ; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >=0 && nx < n && ny >=0 && ny < n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    ans++;
                    board[i][j] = 0;
                    BFS(i,j);
                }
            }
        }

        System.out.println(ans);
    }

}

