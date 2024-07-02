package Promgrammers.Level1;

import java.util.ArrayList;
import java.util.Collections;

public class 문자열내림차순배치하기 {
    public static String solution(String s) {
//        String answer = "";
//        ArrayList<Character> arrayList = new ArrayList<>();
//        for(char x : s.toCharArray()){
//            arrayList.add(x);
//        }
//        Collections.sort(arrayList,Collections.reverseOrder());
//        for(char x :  arrayList){
//            answer +=x;
//        }
//        return answer;
        return s.chars()
                .boxed()
                .sorted((a,b)->b-a)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}
