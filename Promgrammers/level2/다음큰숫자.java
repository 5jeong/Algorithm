package Promgrammers.level2;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = n + 1;
        int cnt = count(n);

        while (true) {
            if (cnt == count(answer)) {
                break;
            }
            answer++;
        }
        return answer;
    }

    // 2진수 변환후 1의 갯수 구하기
    private int count(int n) {
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for (char x : s.toCharArray()) {
            if (x == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
