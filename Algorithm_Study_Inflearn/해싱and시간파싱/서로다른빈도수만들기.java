package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 서로다른빈도수만들기 {
    public static int solution(String s){
        int answer = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        HashSet<Integer> cnt = new HashSet<>();
        for(char x : s.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        for(char x : hashMap.keySet()){

            while(cnt.contains(hashMap.get(x))){
                answer++;
                hashMap.put(x,hashMap.get(x)-1);
            }
            if(hashMap.get(x)==0){
                continue;
            }
            cnt.add(hashMap.get(x));

        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("aaabbbcc"));
        System.out.println(solution("aaabbc"));
        System.out.println(solution("aebbbbc"));
        System.out.println(solution("aaabbbcccde"));
        System.out.println(solution("aaabbbcccdddeeeeeff"));
    }
}
