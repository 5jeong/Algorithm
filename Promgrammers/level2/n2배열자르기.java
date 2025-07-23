package Promgrammers.level2;

public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {

        int len = (int) (right - left + 1);
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            long idx = left + i;
            int x = (int) (idx / n);
            int y = (int) (idx % n);
            answer[i] = Math.max(x, y) + 1;
        }

        return answer;
    }
}
