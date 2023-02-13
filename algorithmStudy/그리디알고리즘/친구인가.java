package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 친구인가 {
    static int[] friend;
    static int Find(int f){
        if(friend[f] == f){
            return f;
        }
        else{
            return friend[f] = Find(friend[f]);
        }
    }
    static void Union(int a,int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb){
            friend[fa] = fb;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        friend = new int[n+1];
        for(int i = 0; i<=n;i++){
            friend[i] = i;
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a,b);
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        a = Find(a);
        b = Find(b);
        if(a==b){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
