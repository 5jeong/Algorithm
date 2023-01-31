package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합의경우수_메모이제이션_DFS {
    static int[][] arr= new int[34][34];
    static int DFS(int n,int r){
        if(arr[n][r] > 0){
            return arr[n][r];
        }
        if(n==r || r==0){
           return 1;
        }
        else{
            return arr[n][r] = DFS(n-1,r-1) + DFS(n-1,r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(DFS(n,r));
    }
}
