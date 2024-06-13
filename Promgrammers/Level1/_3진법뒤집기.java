package Promgrammers.Level1;

public class _3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        answer = Integer.valueOf(reversed,3);
        return answer;
    }
}
