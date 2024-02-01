package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

//팰림드롬 = 앞으로 읽나 뒤로읽나 똑같은수
public class 팰린드롬의경우수 {
    static HashMap<Character, Integer> hashMap;
    static Deque<Character> deque;
    static int n;
    static ArrayList<String> res;

    static void dfs() {
        if (deque.size() == n) {
            String temp = "";
            for (char x : deque) {
                temp += x;
            }
            res.add(temp);

        } else {
            for (char x : hashMap.keySet()) {
                if (hashMap.get(x) == 0) {
                    continue;
                }
                deque.addFirst(x);
                deque.addLast(x);
                hashMap.put(x, hashMap.get(x) - 2);
                dfs();
                deque.pollFirst();
                deque.pollLast();
                hashMap.put(x, hashMap.get(x) + 2);

            }
        }

    }

    public static String[] solution(String s) {
        String[] answer = {};
        n = s.length();
        res = new ArrayList<>();
        hashMap = new HashMap<>();
        deque = new ArrayDeque<>();
        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        int cnt = 0;
        char center = ' ';
        for (char x : hashMap.keySet()) {
            if (hashMap.get(x) % 2 == 1) {
                center = x;
                cnt++;
            }
        }
        if (cnt > 1) {
            return answer;
        }
        if (center != ' ') {
            hashMap.put(center, hashMap.get(center) - 1);
            deque.add(center);
        }
        dfs();
        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaaabb")));
        System.out.println(Arrays.toString(solution("abbcc")));
        System.out.println(Arrays.toString(solution("abbccee")));
        System.out.println(Arrays.toString(solution("abbcceee")));
        System.out.println(Arrays.toString(solution("ffeffaae")));
    }
}
