package Promgrammers.Level1;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        int[] answer = {};
        String str = String.valueOf(n);
        answer = new int[str.length()];
        String reversed = new StringBuilder(str).reverse().toString();
        for (int i = 0; i < str.length(); i++) {
            answer[i] = reversed.charAt(i) - '0';
        }
        return answer;
    }
}
