package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
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

    private long calculate(String op, long left, long right) {
        if (op.equals("+")) {
            return left + right;
        } else if (op.equals("-")) {
            return left - right;
        }
        return left * right;
    }

    private long calculate(List<String> tokens, String[] orderStep) {
        for (String op : orderStep) {
            for (int i = 0; i < tokens.size(); i++) {
                if(tokens.get(i).equals(op)){
                    long left = Long.parseLong(tokens.get(i-1));
                    long right = Long.parseLong(tokens.get(i+1));
                    long res = calculate(op,left,right);
                }
            }
        }

    }

    public long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        for (String[] orderStep : orderSteps) {
            calculate(tokens, orderStep);
        }
        return answer;
    }

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("100-200*300-500+200", "+-*", true);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        String s = "+-*";
        String[] temp = s.split("");
        System.out.println(Arrays.toString(temp));
    }
}
