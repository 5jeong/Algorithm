package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_12851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int cnt = 0;
        int[] visited = new int[100001];
        int[] count = new int[100001];
        visited[n] = 1;
        count[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                break;
            }
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) {
                    continue;
                }
                // 처음 방문
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    count[next] = count[now];
                    queue.offer(next);
                } else if(visited[next] == visited[now] +1){ // 재방문
                    count[next] += count[now];
                }
            }
        }
        System.out.println(visited[k]-1);
        System.out.println(count[k]);
    }

}

