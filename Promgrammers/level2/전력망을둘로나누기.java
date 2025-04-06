package Promgrammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {
    static int[] ch;
    static List<List<Integer>> graph;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] x : wires){
            int a = x[0];
            int b = x[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int ans = Integer.MAX_VALUE;
        for(int[] x : wires){
            ch = new int[n+1];
            int start1 = x[0];
            int start2 = x[1];

            ans = Math.min(ans,Math.abs(dfs(start1,start2) - dfs(start2,start1)));
        }

        return ans;
    }

    private int dfs(int now,int block){
        ch[now] = 1;
        int cnt = 1;
        for(int next : graph.get(now)){
            if(next == block || ch[next]==1){
                continue;
            }
            cnt += dfs(next,block);
        }
        return cnt;
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(start);
//         ch[start]=1;
//         int cnt=0;
//         while(!queue.isEmpty()){
//             int now = queue.poll();
//             cnt++;
//             for(int x : graph.get(now)){
//                 if(x == no){
//                     continue;
//                 }
//                 if(ch[x] == 0){
//                     ch[x] = 1;
//                     queue.add(x);
//                 }
//             }

//         }
//         return cnt;

    }
}
