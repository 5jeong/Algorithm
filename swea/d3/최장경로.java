package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최장경로 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int ans;
    static void dfs(int v,int cost){
        for(int nx : graph.get(v)){
            if(ch[nx]==0){
                ch[nx]=1;
                dfs(nx,cost+1);
                ch[nx]=0;
            }
        }
        ans = Math.max(ans,cost);
    }

    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ans=0;
            ch = new int[n+1];
            graph = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList<Integer>());
            }
            for(int i=0;i<m;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            for(int i=1;i<=n;i++){
                ch[i]=1;
                dfs(i,1);
                ch[i]=0;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
