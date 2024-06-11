package Promgrammers.Level1;

/*
<문제 풀이 흐름>
1. 모든 문자열에 대해 문자 반복.
    a. 알파벳이 아닌경우(공백) 그대로 붙이기
    b. 알파벳인 경우 n만큼 밀어 붙이기 (z일 경우 다음은 a)
 */
public class 시저암호 {
    public static String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            sb.append(push(x, n));
        }
        answer = sb.toString();
        return answer;
    }

    private static char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        int start = Character.isUpperCase(c) ? 'A' : 'B';
        int position = c - start;
        position = (position + n) % 26;
        return (char) (start + position);
    }

    public static void main(String[] args) {
        System.out.println(solution("zzzZ", 4));
    }
}
