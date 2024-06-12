package Promgrammers.Level1;

/*
<문제풀이흐름>
1. 문자열 전체 탐색(공백도 인덱스 포함)
2. 문자가 공백일 경우 그대로 이어붙이기, 인덱스 초기화
3. 문자가 알파벳일경우 대,소문자 변환, 인덱스 증가
4. 반환

 */
public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char x : s.toCharArray()) {
            if (!Character.isAlphabetic(x)) {
                sb.append(x);
                idx = 0;
            } else {
                char temp = idx % 2 == 0 ? Character.toUpperCase(x) : Character.toLowerCase(x);
                sb.append(temp);
                idx++;
            }
        }

        return sb.toString();
    }

}
