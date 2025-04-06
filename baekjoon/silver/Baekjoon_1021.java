package baekjoon.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 회전하는 큐
public class Baekjoon_1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        List<Integer> picks = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            picks.add(sc.nextInt());
        }

        int ans = 0;
        for (int x : picks) {
            int cnt = 0;
            while (x != queue.peek()) {
                queue.add(queue.poll());
                cnt++;
            }
            ans += Math.min(Math.abs(queue.size() - cnt), cnt);
            queue.poll();
        }
        System.out.println(ans);
    }

}
