package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class 팰린드롬의경우수 {

    static HashMap<Character, Integer> hashMap;
    static Deque<Character> deque;
    static int n;
    static ArrayList<String> res;

    static void dfs() {
        if (deque.size() == n) {
            String s = "";
            for (char x : deque) {
                s += x;
            }
            res.add(s);
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
        hashMap = new HashMap<>();
        deque = new LinkedList<>();
        res = new ArrayList<>();
        n = s.length();

        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        int cnt = 0;
        for (char x : hashMap.keySet()) {
            // 홀수가 2개이상이면 펠린드롬 x
            // 홀수이면 deque추가
            if (hashMap.get(x) % 2 == 1) {
                cnt++;
                deque.add(x);
                hashMap.put(x, hashMap.get(x) - 1);
            }
        }
        if (cnt > 1) {
            return new String[]{};
        }
        dfs();
        return res.toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaaabb")));
        System.out.println(Arrays.toString(solution("abbcc")));
        System.out.println(Arrays.toString(solution("abbccee")));
        System.out.println(Arrays.toString(solution("abbcceee")));
        System.out.println(Arrays.toString(solution("ffeffaae")));
    }
}
