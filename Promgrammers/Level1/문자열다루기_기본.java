package Promgrammers.Level1;

public class 문자열다루기_기본 {
    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
//        if (s.length() != 4 && s.length() != 6) {
//            return false;
//        }
//        for (char x : s.toCharArray()) {
//            if (!Character.isDigit(x)) {
//                return false;
//            }
//        }
//        return true;
    }
}

