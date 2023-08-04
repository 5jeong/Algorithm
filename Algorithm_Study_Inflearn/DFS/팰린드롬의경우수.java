package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.*;

//팰림드롬 = 앞으로 읽나 뒤로읽나 똑같은수
public class 팰린드롬의경우수 {
    static ArrayList<String> res;
    static int n;
    static Deque<Character> temp;
    static HashMap<Character,Integer> hashMap;

    static void DFS(){
        if(temp.size() == n){
            String str="";
            for(char y : temp){
                str+=y;
            }
            res.add(str);
            return;
        }
        else{
            for (char x : hashMap.keySet()) {
                if (hashMap.get(x) == 0) {
                    continue;
                } else {
                    temp.addFirst(x);
                    temp.addLast(x);
                    hashMap.put(x, hashMap.get(x)-2);
                    DFS();
                    hashMap.put(x, hashMap.get(x)+2);
                    temp.pollFirst();
                    temp.pollLast();
                }
            }
        }
        return;

    }
    public static String[] solution(String s){
        String[] answer = {};
        res = new ArrayList<>();
        n = s.length();
        temp = new ArrayDeque<>();
        hashMap = new HashMap<>();
        char c = ' ';
        for(char x : s.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        int cnt=0;
        for(char x : hashMap.keySet()){
            if(hashMap.get(x) %2==1){
                c = x;
                cnt++;
            }
            if(cnt==2){
                return answer;
            }
        }

        if(c!=' '){
            temp.add(c);
            hashMap.put(c, hashMap.get(c)-1);
        }
        DFS();

        answer = new String[res.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("aaaabb")));
        System.out.println(Arrays.toString(solution("abbcc")));
        System.out.println(Arrays.toString(solution("abbccee")));
        System.out.println(Arrays.toString(solution("abbcceee")));
        System.out.println(Arrays.toString(solution("ffeffaae")));
    }
}
