package Promgrammers.level2;

public class 타겟넘버 {
    static int ans, n;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        ans = 0;
        n = numbers.length;
        dfs(0, 0, numbers, target);
        return ans;
    }

    private void dfs(int L, int sum, int[] numbers, int target) {
        if (L == n) {
            if (sum == target) {
                ans++;
            }
        } else {
            dfs(L + 1, sum + numbers[L], numbers, target);
            dfs(L + 1, sum - numbers[L], numbers, target);
        }
    }
}
