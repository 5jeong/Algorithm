package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 집으로이동 {
    public static int solution(int[] pool, int a, int b, int home) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ch = new int[2][10001];
        for (int x : pool) {
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        queue.offer(new int[]{0, 0});
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] temp = queue.poll();
                if (temp[0] == home) {
                    return answer;
                }
                int nx = temp[0] + a;
                if (nx >= 0 && nx < 10001 && ch[0][nx] == 0) {
                    ch[0][nx] = 1;
                    queue.offer(new int[]{nx, 0});
                }
                nx = temp[0] - b;
                if (temp[1] == 0 && nx >= 0 && ch[1][nx] == 0) {
                    ch[1][nx] = 1;
                    queue.offer(new int[]{nx, 1});
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
