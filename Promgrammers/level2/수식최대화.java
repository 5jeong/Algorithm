package Promgrammers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식최대화 {
    static List<String[]> orderSteps = List.of(
            "+-*".split(""),
            "+*-".split(""),
            "-*+".split(""),
            "-+*".split(""),
            "*-+".split(""),
            "*+-".split(""));

    private static long calculate(String op, long left, long right) {
        if (op.equals("+")) {
            return left + right;
        } else if (op.equals("-")) {
            return left - right;
        }
        return left * right;
    }

    private static Long calculate(List<String> tokens, String[] orderStep) {
        for (String op : orderStep) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long res = calculate(op, left, right);
                    tokens.remove(i + 1);
                    tokens.remove(i);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(res));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));

    }

    public static long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        for (String[] orderStep : orderSteps) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(tokens), orderStep)));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }
}
