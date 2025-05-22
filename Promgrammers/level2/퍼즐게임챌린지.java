package Promgrammers.level2;

public class 퍼즐게임챌린지 {
    static int n;

    // 이분탐색
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        n = diffs.length;
        int lt = 1;
        int rt = 100000;
        int mid = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    static boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long time = times[0];
        for (int i = 1; i < n; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = times[i - 1];
            if (diff <= level) {
                time += timeCur;
            } else {
                time += (long) (timeCur + timePrev) * (diff - level) + timeCur;
            }
        }
        return time <= limit;
    }
}
