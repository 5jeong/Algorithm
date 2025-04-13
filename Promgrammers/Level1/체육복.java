package Promgrammers.Level1;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = n;
        int[] arr = new int[n + 1];

        for (int x : lost) {
            arr[x]--;
        }

        for (int x : reserve) {
            arr[x]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1) {
                if (i - 1 > 0 && arr[i - 1] == 1) {
                    arr[i]++;
                    arr[i - 1]--;
                } else if (i + 1 <= n && arr[i + 1] == 1) {
                    arr[i]++;
                    arr[i + 1]--;
                } else {
                    ans--;
                }
            }
        }

        return ans;
    }
}
