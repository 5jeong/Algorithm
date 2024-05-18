package Algorithm_Study_Inflearn.자료구조활용;

import com.sun.source.tree.Tree;
import java.util.*;

class Solution {
    public static int solution(int n, int[][] meetings) {
        int answer = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] x : meetings) {
            int startTime = x[0];
            while (!pq.isEmpty() && startTime >= pq.peek()[0]) {
                rooms.add(pq.poll()[1]);
            }

            if (!rooms.isEmpty()) {
                int num = rooms.pollFirst();
                pq.add(new int[]{x[1], num});
                res[num]++;
            } else {
                int[] temp = pq.poll();
                int a = temp[0] + (x[1] - x[0]);
                pq.add(new int[]{a, temp[1]});
                res[temp[1]]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < res[i]) {
                max = res[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}