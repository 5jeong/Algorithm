package Algorithm_Study_Inflearn.그래프;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정 {
    public static String[] solution(String[] subjects, String[] course){

        int n = subjects.length;
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        for(int i=0;i<n;i++){
            hashMap.put(subjects[i],i);
        }
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(String x : course){
            int a = hashMap.get(x.split(" ")[0]);
            int b = hashMap.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            res.add(temp);
            for(int x : graph.get(temp)){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.add(x);
                }
            }
        }
        String[] answer =  new String[n];
        for(int i=0;i<n;i++){
            answer[i] = subjects[res.get(i)];
        }
        for(String x : answer){
            System.out.print(x+" ");
        }
        System.out.println();
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
