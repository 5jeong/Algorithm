package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합구하기_DFS {
    static int[] check;
    static int n;
    static void DFS(int L){
        if(L>n){
            String temp="";
            for(int i=1;i<=n;i++){
                if(check[i]==1){
                    temp += (i+" ");
                }
            }
            System.out.println(temp);
        }
        else{
            check[L]=1;
            DFS(L+1);
            check[L]=0;
            DFS((L+1));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check=new int[n+1];
        DFS(1);
    }
}
