package Promgrammers.level2;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        int minMove = n - 1;
        for (int i = 0; i < n; i++) {
            // 알파벳 바꾸는 최소 비용
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 26 - (c - 'A'));

            // 이동경로 최소비용
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 앞으로 가는 경우와 뒤로 우회해서 가는 경우중 최소 비용
            minMove = Math.min(minMove, i * 2 + (n - next));

            // 뒤로 먼저 가는 경우와의 최소비용 비교
            minMove = Math.min(minMove, (n - next) * 2 + i);
        }

        answer += minMove;

        return answer;
    }
}
