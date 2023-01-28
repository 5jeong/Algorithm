package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지찾기_BFS {
    static int[] check = new int[10001];
    static int[] dis = {1,-1,5};
    public static int BFS(int s,int e){
        check[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int x = q.poll();
                for(int k : dis){
                    int nx = x + k;
                    if(nx == e){
                        return L+1;
                    }
                    if(nx > 0 && nx <= 10000 && check[nx]==0){
                        q.offer(nx);
                        check[nx] =1;
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int ans= 0;
        ans = BFS(s,e);
        System.out.println(ans);
    }
}
