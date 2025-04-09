package Promgrammers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로 {
    static int n;
    static Map<String, List<Ticket>> graph;
    static List<String> res;

    class Ticket {
        String end; // 목적지
        int visited;

        Ticket(String end, int visited) {
            this.end = end;
            this.visited = visited;
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        graph = new HashMap<>();
        res = new ArrayList<>();
        n = tickets.length ;
        for (String[] x : tickets) {
            String now = x[0];
            String next = x[1];
            if (graph.get(now) == null) {
                graph.put(now, new ArrayList<Ticket>());
            }
            graph.get(now).add(new Ticket(next, 0));
        }

        for(List<Ticket> t : graph.values()){
            t.sort((a,b)-> a.end.compareTo(b.end));
        }
        dfs(0,"ICN",new ArrayList<>());

        return res.toArray(new String[0]);
    }

    private boolean dfs(int L, String start,List<String> path) {

        path.add(start);

        // 맨처음 찾아진값이 답임.
        if (L == n) {
            res = new ArrayList<>(path);
            return true;
        }

        if(graph.containsKey(start)){
            for (Ticket t : graph.get(start)) {
                if (t.visited == 0) {
                    t.visited = 1;
                    if(dfs(L + 1, t.end,path)){
                        return true;
                    }
                    t.visited = 0;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }
}
