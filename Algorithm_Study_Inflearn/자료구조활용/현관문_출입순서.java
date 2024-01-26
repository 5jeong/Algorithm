package Algorithm_Study_Inflearn.자료구조활용;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 현관문_출입순서 {
    public static int[] solution(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];
        boolean prev = true;
        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();
        int cnt = 0;
        for (int t = 0; ; t++) {
            for (int i = 0; i < arrival.length; i++) {
                if (arrival[i] == t) {
                    if (state[i] == 1) {
                        out.add(i);
                    } else {
                        in.add(i);
                    }
                }
            }
            if (in.isEmpty() && out.isEmpty()) {
                prev = true;
                continue;
            }
            if (prev) {
                if (out.isEmpty()) {
                    answer[in.poll()] = t;
                    prev = false;
                } else {
                    answer[out.poll()] = t;
                    prev = true;
                }
            } else {
                if (in.isEmpty()) {
                    answer[out.poll()] = t;
                    prev = true;
                } else {
                    answer[in.poll()] = t;
                    prev = false;
                }
            }
            cnt++;
            if (cnt == arrival.length) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(
                solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
