package Promgrammers.Level1;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        s = s.toUpperCase();
        int pCnt=0;
        int yCnt=0;
        pCnt = s.length() - s.replace("P","").length();
        yCnt = s.length() - s.replace("Y","").length();
        return pCnt == yCnt;
    }
}
