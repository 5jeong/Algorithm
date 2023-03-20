package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,1,5};
    static int[] arr = new int[10001];
    static int s,e;
    static void BFS(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int x : dx){
                int nx = temp + x;
                if(nx >=1 && nx <= 10000 && arr[nx]==0){
                    queue.add(nx);
                    arr[nx] = arr[temp] +1;
                }
                if(nx==e){
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        BFS(s);

        System.out.println(arr[e]);
    }
}
