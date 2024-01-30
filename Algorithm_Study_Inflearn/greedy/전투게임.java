package Algorithm_Study_Inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 전투게임 {
    static class info implements Comparable<info> {
        int num;
        String team;
        int attack;

        info(int num, String team, int attack) {
            this.num = num;
            this.team = team;
            this.attack = attack;
        }

        @Override
        public int compareTo(info o) {
            return this.attack - o.attack;
        }
    }

    public static int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<info> infos = new ArrayList<>();
        int idx = 0;
        for (String x : students) {
            infos.add(new info(idx, x.split(" ")[0], Integer.parseInt(x.split(" ")[1])));
            idx++;
        }
        Collections.sort(infos);

        HashMap<String, Integer> teamPoint = new HashMap<>();
        int total = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            for (; j < n; j++) {
                if (infos.get(j).attack < infos.get(i).attack) {
                    total += infos.get(j).attack;
                    String x = infos.get(j).team;
                    teamPoint.put(x, teamPoint.getOrDefault(x, 0) + infos.get(j).attack);
                } else {
                    break;
                }
            }
            answer[infos.get(i).num] = total - teamPoint.getOrDefault(infos.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(
                Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(
                Arrays.toString(solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(
                Arrays.toString(solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
