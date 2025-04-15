package Promgrammers.level3;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int now = Integer.MIN_VALUE;

        for (int[] x : routes) {
            if (x[0] > now) {
                answer++;
                now = x[1];
            }
        }
        return answer;
    }

}
