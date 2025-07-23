package Promgrammers.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> hashMap = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1],0)+1);
        }

        for(String x : hashMap.keySet()){
            answer *= hashMap.get(x)+1;
        }
        return answer-1;
    }
}
