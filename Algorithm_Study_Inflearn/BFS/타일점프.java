package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 타일점프 {
    public static int solution(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int L = 0;
        int[] ch = new int[101];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                if (temp == n - 1) {
                    return L;
                }
                for (int j = 1; j <= nums[temp]; j++) {
                    int nx = temp + j;
                    if (ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;


    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
