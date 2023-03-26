package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기_DFS {
    static int n,m;
    static int[] arr,check,pm;
    static void DFS(int L){

        if(L==m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
            for(int i=0;i<n;i++){
                if(check[i]==0){
                    check[i]=1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        check = new int[n];
        pm = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
    }
}
