package Algorithm_Study_Inflearn.그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정 {
    public static String[] solution(String[] subjects, String[] course) {
        String[] answer;
        int n = subjects.length;
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(subjects[i], i);
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (String x : course) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            indegree[hashMap.get(a)]++;
            graph.get(hashMap.get(a)).add(hashMap.get(b));
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res.add(temp);
            for (int i = 0; i < graph.size(); i++) {
                if (graph.get(i).contains(temp)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        answer = new String[res.size()];
        for (int i = 0; i < n; i++) {
            answer[i] = subjects[res.get(i)];
        }
        for (String x : answer) {
            System.out.print(x + " ");
        }
        System.out.println();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"english", "math", "physics", "art", "music"},
                new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(solution(new String[]{"art", "economics", "history", "chemistry"},
                new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(solution(new String[]{"math", "science", "music", "biology"},
                new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
