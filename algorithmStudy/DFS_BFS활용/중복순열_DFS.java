package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열_DFS {
    static int n,m;
    static int[] arr;
    static void DFS(int L){
        if(L==m){
            for(int x :arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else{
            for(int i=1;i<=n;i++){
                arr[L] = i;
                DFS(L+1);
            }
        }
        return ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        DFS(0);
    }
}
