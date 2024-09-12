package Promgrammers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    private static Queue<Integer> queue;

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        queue = new ArrayDeque();
        endProgresses(progresses, speeds);
        List<Integer> res = new ArrayList<>();

        int day = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp > day) {
                if (day != 0) {
                    res.add(cnt);
                    cnt = 1;
                }
                day = temp;
            }
            cnt++;
        }
        // 마지막 작업
        res.add(cnt);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // 각각 개발 끝나는 시간을 계산하여 queue에 저장
    private static void endProgresses(int[] progresses, int[] speeds) {
        for (int i = 0; i < progresses.length; i++) {
            int a = (100 - progresses[i]) / speeds[i];
            int temp = (100 - progresses[i]) % speeds[i] == 0 ? a : a + 1;
            queue.add(temp);
        }
    }

    public static void main(String[] args) {
//        int[] progress = {93, 30, 55};
//        int[] s = {1, 30, 5};
//        solution(progress, s);

        int[] progress2 = {95, 90, 99, 99, 80, 99};
        int[] s2 = {1, 1, 1, 1, 1, 1};
        solution(progress2, s2);
    }

}
