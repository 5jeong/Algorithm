package baekjoon.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b));
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty()) {
                    ans.append("0").append("\n");
                    continue;
                }
                ans.append(pq.poll()).append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.println(ans);
    }
}
