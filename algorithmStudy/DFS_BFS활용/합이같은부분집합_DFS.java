package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이같은부분집합_DFS {
    static int n,total=0;
    static String ans = "NO";
    static int[] arr;
    static void DFS(int L,int sum){

        if(ans=="YES"){
            return;
        }
        if(sum > total-sum){
            return;
        }
        if(L== n){
            if(total-sum == sum){
                ans = "YES";
            }
        }
        else{
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr=  new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            total +=arr[i];
        }
        DFS(0,0);
        System.out.println(ans);
    }
}
