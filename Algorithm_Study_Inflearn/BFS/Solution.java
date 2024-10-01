package Algorithm_Study_Inflearn.BFS;

import java.util.*;

class Solution {
    public int solution(int s, int e) {
        int L = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[][] ch = new int[2][200001];
        queue.offer(s);
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            e += L;
            if (e > 200000) {
                return -1;
            }
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                for (int nx : new int[]{temp + 1, temp - 1, temp * 2}) {
                    // -1 , 1 특성상 짝수는 짝수로 이동할수 있고, 홀수는 홀수로 이동 가능
                    if (nx >= 0 && nx < 200001 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }

            // 홀수레벨 ch[1][nx]은 현재 홀수레벨에서 모두 방문 가능 지점
            // 짝수레벨 ch[0][nx]은 현재 짝수레벨에서 모두 방문 가능 지점
            if (ch[L % 2][e] == 1) {
                return L;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}