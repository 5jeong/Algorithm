package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 문제집
public class Baekjoon_1766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제 수
        int m = sc.nextInt(); // 문제 정보 개수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            inDegree[b]++;
            graph.get(a).add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=n;i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            int now = pq.poll();
            ans.append(now).append(" ");
            for(int next : graph.get(now)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    pq.add(next);
                }
            }
        }
        System.out.println(ans);

    }
}
