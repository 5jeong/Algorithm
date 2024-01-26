package Algorithm_Study_Inflearn.자료구조활용;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 피부과 {
    public static int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        ArrayList<Integer> visitTime = new ArrayList<>();
        ArrayList<Integer> endTime = new ArrayList();
        int a = 0;
        int b = calculateMinute(enter[0]);
        for (String x : enter) {
            int laserIdx = Integer.parseInt(x.split(" ")[1]);
            a = calculateMinute(x);
            b += laser[laserIdx];
            if (b < a) {
                b = a + laser[laserIdx];
            }
            visitTime.add(a);
            endTime.add(b);
        }
        int visitIdx = 0;
        int endIdx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int t = visitTime.get(0); t <= 1200; t++) {
            if (visitIdx < n && t == visitTime.get(visitIdx) && t < endTime.get(endIdx)) {
                queue.offer(visitIdx);
                visitIdx++;
            }
            if (endIdx < n && t == endTime.get(endIdx)) {
                queue.poll();
                endIdx++;
                answer = Math.max(answer, queue.size());
            }
        }

        return answer;
    }

    static int calculateMinute(String str) {
        String time = str.split(" ")[0];
        String a = time.split(":")[0];
        String b = time.split(":")[1];
        return Integer.parseInt(a) * 60 + Integer.parseInt(b);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{30, 20, 25, 15},
                new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(solution(new int[]{30, 20, 25, 15},
                new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0",
                        "15:25 0"}));
        System.out.println(solution(new int[]{30, 20, 25, 15},
                new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }

}
