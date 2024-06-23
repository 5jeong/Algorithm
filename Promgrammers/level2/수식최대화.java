package Promgrammers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <문제풀이 흐름>
 *     0. 완전탐색 (수식 우선순위 6가지 리스트 만들기)
 *     1. 주어진 문자열을 숫자, 수식으로 쪼개기(List)
 *     2. 수식에 맞게 계산 a. 수식일때 인덱스(i)를 찾고 계산후에, 리스트 업데이트
 *        b. i-1에 계산결과 넣기
 *        c. i 인덱스 맞게 변경 (i-=1)
 *     3. 결과값중 최댓값(절대값 기준)으로 계산
 */
public class 수식최대화 {
    static List<String[]> orderList = List.of(
            "*+-".split(""),
            "*-+".split(""),
            "+*-".split(""),
            "+-*".split(""),
            "-*+".split(""),
            "-+*".split(""));

    private long calculate(long a, long b, String op) {
        if (op.equals("*")) {
            return a * b;
        }
        if (op.equals("+")) {
            return a + b;
        }
        return a - b;
    }

    private long calculate(List<String> tokens, String[] order) {
        for (String x : order) {
            for (int i = 0; i < tokens.size(); i++) {
                if (x.equals(tokens.get(i))) {
                    long a = Long.parseLong(tokens.get(i - 1));
                    long b = Long.parseLong(tokens.get(i + 1));
                    long res = calculate(a, b, x);
                    tokens.remove(i + 1);
                    tokens.remove(i);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(res));
                    i -= 1;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        for (String[] x : orderList) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(tokens), x)));
        }
        return answer;
    }

}
