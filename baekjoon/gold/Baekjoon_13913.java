package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_13913 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] visited = new int[100001]; // 방문시간
        int[] parent = new int[100001]; // 부모(이전 위치) 기록
        visited[n] = 1;
        parent[n] = -1; // 시작점은 부모 없음

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                System.out.println(visited[now]-1);
                break;
            }
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    parent[next] = now;
                    queue.offer(next);
                }
            }
        }

        // 경로 복원
        Stack<Integer> stack = new Stack<>();
        for (int i = k; i != -1; i = parent[i]) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
