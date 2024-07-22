package Promgrammers.level0;

import java.util.HashMap;
import java.util.Map;

public class A로B만들기 {
    private static Map<Character,Integer> toMap(String word){
        Map<Character,Integer> map = new HashMap<>();
        for(char x : word.toCharArray()){
            map.putIfAbsent(x,0);
            map.put(x,map.get(x)+1);
        }
        return map;
    }
    public int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
}
