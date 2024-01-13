package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 회장선거 {
    public static String solution(String[] votes, int k) {
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> voteResult = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String x : votes) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<>());
            voteHash.get(a).add(b);
            voteResult.put(b, voteResult.getOrDefault(b, 0) + 1);
        }
        int max = 0;
        for (String x : voteHash.keySet()) {
            for (String y : voteHash.get(x)) {
                if (voteResult.get(y) >= k) {
                    present.put(x, present.getOrDefault(x, 0) + 1);
                }
            }
            max = Math.max(max, present.get(x));
        }
        ArrayList<String> result = new ArrayList<>();
        for (String x : present.keySet()) {
            if (max == present.get(x)) {
                result.add(x);
            }
        }
        Collections.sort(result);
        answer = result.get(0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"},
                        2));
        System.out.println(solution(
                new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park",
                        "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(solution(
                new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom",
                        "luis john"}, 2));
        System.out.println(solution(
                new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis",
                        "tom bob", "tom luis", "john park", "park john"}, 3));
    }

}
