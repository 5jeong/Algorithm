package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class 팰린드롬의경우수 {
    static int n;
    static List<String> res;
    static HashMap<Character, Integer> hashMap;
    static Deque<Character> deque;

    private static void dfs() {
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
        hashMap = new HashMap<>();
        deque = new ArrayDeque<>();
        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        int cnt = 0;
        for (char x : hashMap.keySet()) {
            if (cnt > 1) {
                return new String[]{};
            }
            if (hashMap.get(x) % 2 == 1) {
                cnt++;
                deque.add(x);
                hashMap.put(x, hashMap.get(x) - 1);
            }
        }
        res = new ArrayList<>();
        dfs();
        answer = res.stream().toArray(String[]::new);
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
