package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 서로다른빈도수만들기 {
    public static int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (char x : hashMap.keySet()) {
            int temp = hashMap.get(x);
            while (hashSet.contains(temp) && temp > 0) {
                temp--;
                answer++;
            }
            if (temp == 0) {
                continue;
            }
            hashSet.add(temp);
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
