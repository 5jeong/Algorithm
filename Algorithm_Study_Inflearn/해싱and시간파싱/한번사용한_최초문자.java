package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.HashMap;

public class 한번사용한_최초문자 {
    public static int solution(String s){
        int answer = 0;
        int n = s.length();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char x : s.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        for(int i=0;i<n;i++){
            if(hashMap.get(s.charAt(i))==1){
                answer=i+1;
                return answer;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }

}
