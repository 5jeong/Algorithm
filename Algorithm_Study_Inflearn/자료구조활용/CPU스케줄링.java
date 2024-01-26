package Algorithm_Study_Inflearn.자료구조활용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU스케줄링 {
    public static int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];
        int n = tasks.length;
        LinkedList<int[]> programs = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ft = 0;
        while (true) {
            if (pq.isEmpty()) {
                ft = Math.max(ft, programs.peek()[0]);
            }
            while (!programs.isEmpty() && ft >= programs.peek()[0]) {
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] temp = pq.poll();
            ft += temp[0];
            res.add(temp[1]);
            if (res.size() == n) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(
                Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
