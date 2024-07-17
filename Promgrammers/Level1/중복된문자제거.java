package Promgrammers.Level1;

import java.util.LinkedHashSet;
import java.util.Set;

public class 중복된문자제거 {
    public static String solution(String my_string) {
        String answer = "";
        Set<Character> set = new LinkedHashSet();
        for(char x : my_string.toCharArray()){
            set.add(x);
        }
        for(char x : set){
            answer+=x;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("people"));
        System.out.println(solution("We are the world"));
    }
}
