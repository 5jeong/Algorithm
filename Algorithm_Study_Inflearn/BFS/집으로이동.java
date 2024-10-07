package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 집으로이동 {
    // 연속 뒤로 점프X
    // pool 지점 못감
    // a만큼 앞으로 b만큼 뒤로
    // 최소 점프 횟수
    public static int solution(int[] pool, int a, int b, int home) {
        Queue<int[]> queue = new LinkedList<>();
        int L = 0;
        // 앞 : [][1], 뒤 : [][0]
        int[][] ch = new int[10001][2];
        int[] dx = {a, -b};
        // 못가는곳 체크
        for (int x : pool) {
            ch[x][0] = 1;
            ch[x][1] = 1;
        }
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] temp = queue.poll();
                if (temp[0] == home) {
                    return L;
                }
                // 앞으로 점프
                int nx = temp[0] + a;
                if (nx < 10001 && ch[nx][1] == 0) {
                    ch[nx][1] = 1;
                    queue.offer(new int[]{nx, 1});
                }
                // 뒤로 점프(이전 점프가 뒤면 못감)
                nx = temp[0] - b;
                if (nx >= 0 && temp[1] != 0 && ch[nx][0] == 0) {
                    ch[nx][0] = 1;
                    queue.offer(new int[]{nx, 0});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(solution(new int[]{10, 15, 20}, 3, 2, 2));
        System.out.println(solution(new int[]{9, 20, 35}, 4, 3, 15));
        System.out.println(solution(new int[]{7, 14, 21}, 3, 2, 8));

    }
}
