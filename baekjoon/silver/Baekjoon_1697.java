package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * 숨바꼭질
 * 수빈이는 x-1,x+1,2*x 위치로 이동가능
 * 동생의 위치가 주어질때, 찾는 가장 빠른 시간 구하기
 * 레벨 탐색 (BFS)
 *
 */
public class Baekjoon_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[100001];
        queue.offer(n);
        ch[n] = 1;
        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                if (temp == k) {
                    System.out.println(L);
                    return;
                }
                for (int x : new int[]{temp - 1, temp + 1, temp * 2}) {
                    if (x >= 0 && x <= 100000 && ch[x] == 0) {
                        ch[x] = 1;
                        queue.offer(x);
                    }
                }
            }
            L++;
        }
    }
}
