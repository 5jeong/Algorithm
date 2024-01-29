package Algorithm_Study_Inflearn.greedy;

import java.util.ArrayList;

public class 꽃이피는최단시간 {
    public static int solution(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new int[]{plantTime[i], growTime[i]});
        }
        arrayList.sort((a, b) -> b[1] - a[1]);
        int s = 0, e = 0;
        for (int[] x : arrayList) {
            e = s + x[0] + x[1];
            s += x[0];
            answer = Math.max(answer, e);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}