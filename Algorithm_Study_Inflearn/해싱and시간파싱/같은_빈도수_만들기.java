package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.Arrays;
import java.util.HashMap;

public class 같은_빈도수_만들기 {
    public static int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=97;i<102;i++){
            hashMap.put((char)i,0);
        }
        for(char x : s.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char x : hashMap.keySet()){
            max = Math.max(max,hashMap.get(x));
        }
        for(int i=0;i<hashMap.size();i++){
            answer[i] = max - hashMap.get((char)(i+97));
        }



        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("aaabc")));
        System.out.println(Arrays.toString(solution("aabb")));
        System.out.println(Arrays.toString(solution("abcde")));
        System.out.println(Arrays.toString(solution("abcdeabc")));
        System.out.println(Arrays.toString(solution("abbccddee")));
    }
}
