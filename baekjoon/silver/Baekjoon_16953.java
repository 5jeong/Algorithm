package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// A -> B
public class Baekjoon_16953 {
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        ans = -1;

        bfs(a, b);

        System.out.println(ans);
    }

    static void bfs(long num, long target) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(num);
        int L = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                long now = queue.poll();
                if (now == target) {
                    ans = L;
                    return;
                }
                for (long x : new long[]{now * 2, now * 10 + 1}) {
                    if (x <= target) {
                        queue.add(x);
                    }
                }
            }
            L++;
        }
    }
}
