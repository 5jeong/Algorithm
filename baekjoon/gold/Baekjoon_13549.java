package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13549 {
    static class Node {
        int idx;
        int time;

        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();

        int[] visited = new int[100001];
        queue.add(new Node(n, 0));
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            int now = temp.idx;
            int time = temp.time;
            visited[now] = 1;

            if (temp.idx == k) {
                ans = Math.min(ans, temp.time);
            }

            int[] next = new int[]{now - 1, now + 1, now * 2};

            for (int i = 2; i >= 0; i--) {
                if (i == 2) {
                    if (isPossible(next[i], visited)) {
                        queue.offer(new Node(next[i], time));
                    }
                } else {
                    if (isPossible(next[i], visited)) {
                        queue.offer(new Node(next[i], time + 1));
                    }
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean isPossible(int next, int[] visited) {
        return next >= 0 && next <= 100000 && visited[next] == 0;
    }
}
