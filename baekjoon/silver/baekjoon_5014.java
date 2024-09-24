package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_5014 {
    static int f, s, g, u, d;
    static Queue<Integer> queue;
    static int[] ch, arr;

    static void bfs() {
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                if(temp == g){
                    System.out.println(L);
                    return;
                }
                for(int j=0;j<2;j++){
                    int nx = temp + arr[j];
                    if(nx == g){
                        System.out.println(L+1);
                        return;
                    }
                    if(nx >0 && nx <= f && ch[nx]==0){
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ch = new int[f+1];
        arr = new int[]{u,-d};
        queue = new LinkedList<>();
        queue.add(s);
        bfs();
    }
}
