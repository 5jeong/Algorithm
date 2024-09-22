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
            this.x=x;
            this.y=y;
        }
    }
    static int n,m;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();
    static int[][] city;
    static int[] combi;
    static int len,ans=Integer.MAX_VALUE;
    static void DFS(int L,int s) {
        if (L == m) {
            int sum =0;
            for (Point house : house) {
                int dis = Integer.MAX_VALUE;
                for (int x : combi) {
                    dis = Math.min(dis, Math.abs(house.x - pizza.get(x).x) + Math.abs(house.y - pizza.get(x).y));
                }
                sum+=dis;
            }
            ans = Math.min(ans,sum);
        }
        else{
            for(int i=s;i<len;i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];
        city = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j]==1){
                    house.add(new Point(i+1,j+1));
                }
                else if (city[i][j]==2){
                    len++;
                    pizza.add(new Point(i+1,j+1));
                }
            }
        }
        DFS(0,0);
        System.out.println(ans);
    }
}
