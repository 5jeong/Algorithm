package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 피자배달거리_DFS {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,len,ans=Integer.MAX_VALUE;
    static int[][] board;
    static int[] combi;
    static ArrayList<Point> house,pizza;
    static void DFS(int L,int s){
        if(L==m){
            int sum = 0;
            for(Point p : house){
                int dis = Integer.MAX_VALUE;
                for(int x : combi){
                    dis = Math.min(dis,Math.abs((p.x - pizza.get(x).x)) + Math.abs((p.y - pizza.get(x).y)));
                }
                sum += dis;
            }
            ans = Math.min(ans,sum);
        }
        else{
            for(int i=s;i<len;i++){
                combi[L] = i;
                DFS(L+1,i+ 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        house = new ArrayList<>();
        pizza = new ArrayList<>();
        combi = new int[m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    house.add(new Point(i,j));
                }
                if(board[i][j] == 2){
                    pizza.add(new Point(i,j));
                }
            }
        }
        len = pizza.size();
        DFS(0,0);
        System.out.println(ans);
    }
}
