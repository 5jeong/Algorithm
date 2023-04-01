package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로탐색_BFS {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int ans=0;
    static Queue<Main.Point> queue = new LinkedList<>();

    static void BFS() {
        while(!queue.isEmpty()){
            int nx,ny;
            Main.Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] ==0) {
                    board[nx][ny]=1;
                    dis[nx][ny] = dis[temp.x][temp.y]+1;
                    queue.add(new Main.Point(nx,ny));
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new Main.Point(1,1));
        BFS();

        if(dis[7][7]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(dis[7][7]);
        }
    }
}
