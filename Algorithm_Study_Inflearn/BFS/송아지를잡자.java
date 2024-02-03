package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지를잡자 {

    public static int solution(int s, int e) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[][] ch = new int[2][200001];
        queue.offer(s);
        ch[0][s] = 1;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            e += cnt;
            if (e > 200000) {
                return -1;
            }
            answer++;
            int a = answer % 2;
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                for (int nx : new int[]{temp + 1, temp - 1, temp * 2}) {
                    if (nx == e) {
                        return answer;
                    }
                    if (nx >= 0 && nx < 200000 && ch[a][nx] == 0) {
                        ch[a][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 11));
        System.out.println(solution(10, 3));
        System.out.println(solution(1, 34567));
        System.out.println(solution(5, 6));
        System.out.println(solution(2, 54321));
    }
}
