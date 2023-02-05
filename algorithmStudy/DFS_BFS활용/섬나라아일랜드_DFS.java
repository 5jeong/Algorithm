package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬나라아일랜드_DFS {

    static int n;
    static int[][] board ;
    static int[][] ch ;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static int ans =0;

    static void DFS(int x,int y){
        for (int dir = 0; dir < 8; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        ch = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ch[0][0] = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1 && ch[i][j] == 0){
                    ans++;
                    ch[i][j] = 1;
                    DFS(i,j);
                }
            }
        }

        System.out.println(ans);
    }
}
