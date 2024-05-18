package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.*;

class Solution {
    public String[] solution(String[] reports, int time) {
        String[] answer = {};
        HashMap<String, Integer> inTime = new HashMap<>();
        HashMap<String, Integer> useTime = new HashMap<>();
        for (String x : reports) {
            String name = x.split(" ")[0];
            int minute = getMinute(x.split(" ")[1]);
            String inAndOut = x.split(" ")[2];
            if (inAndOut.equals("in")) {
                inTime.put(name, minute);
            } else {
                useTime.put(name, useTime.getOrDefault(name, 0) + minute - inTime.get(name));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String x : useTime.keySet()) {
            if (useTime.get(x) > time) {
                result.add(x);
            }
        }
        Collections.sort(result);
        answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    static int getMinute(String time) {
        String a = time.split(":")[0];
        String b = time.split(":")[1];
        return Integer.parseInt(a) * 60 + Integer.parseInt(b);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in",
                        "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(
                new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in",
                        "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(
                new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out",
                        "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(
                new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in",
                        "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}