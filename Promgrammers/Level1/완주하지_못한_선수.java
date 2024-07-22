package Promgrammers.Level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(String x : completion){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(String x : participant){
            if(!map.containsKey(x)){
                return x;
            }
            map.put(x,map.get(x)-1);
            if(map.get(x) < 0){
                return x;
            }
        }
        return answer;
    }
}
