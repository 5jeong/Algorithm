package baekjoon.gold;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> small = new PriorityQueue(Collections.reverseOrder()); // 최대힙
        PriorityQueue<Integer> big = new PriorityQueue(); // 최소힙
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            // 번갈아가면서 넣기
            if (i % 2 == 1) { // 홀수일때는 최대힙에 넣기
                small.add(num);
            } else { // 짝수일때는 최소힙에 넣기
                big.add(num);
            }
            if (!small.isEmpty() && !big.isEmpty()) {
                int smallPeek = small.peek();
                int bigPeek = big.peek();
                if (smallPeek > bigPeek) {
                    big.add(small.poll());
                    small.add(big.poll());
                }
            }
            ans.append(small.peek()).append("\n");
        }
        System.out.println(ans);

    }

}
