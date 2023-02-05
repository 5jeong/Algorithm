package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합구하기 {
    static int n,m;
    static int[] arr,combi;
    static void DFS(int L,int s){
        if(L==m){
            for(int x : combi){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else{
            for(int i=s;i<=n;i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi=  new int[m];
        arr = new int[n];
        DFS(0,1);
    }
}
