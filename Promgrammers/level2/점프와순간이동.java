package Promgrammers.level2;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        int num = n;

        while (num > 0) {
            // 홀수일때는 건전지 1사용
            if (num % 2 == 1) {
                num--;
                ans++;
            } else {
                num /= 2;
            }
        }

        return ans;
    }
}
