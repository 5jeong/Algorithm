package Promgrammers.level3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long lt = 0;
        long rt = (long) times[times.length - 1] * n;
        long ans = rt;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            if (isPossible(mid,times,n)) {
                rt = mid - 1;
                ans = Math.min(ans,mid);
            } else {
                lt = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(long mid, int[] times,int n) {
        long cnt = 0;
        for(int time : times){
            cnt += mid / time;
        }
        return cnt >= n;

    }
}
