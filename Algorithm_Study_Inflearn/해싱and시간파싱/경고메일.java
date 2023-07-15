package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 경고메일 {

    static int getTimes(String time){
        int H = Integer.parseInt(time.split(":")[0]) * 60;
        int M = Integer.parseInt(time.split(":")[1]);
        return H+M;
    }
    public static String[] solution(String[] reports, int time){
        String[] answer = {};
        HashMap<String,Integer> inTime = new HashMap<>();
        HashMap<String ,Integer> outTime = new HashMap<>();
        for(String x :reports){
            String name = x.split(" ")[0];
            int t = getTimes(x.split(" ")[1]);
            if(x.split(" ")[2].equals("in")){
                inTime.put(name,inTime.getOrDefault(name,0)+t);
            }
            else{
                outTime.put(name,outTime.getOrDefault(name,0)+t);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(String x : inTime.keySet()){
            int useTime = outTime.get(x) - inTime.get(x);
            if(useTime > time){
                ans.add(x);
            }
        }
        Collections.sort(ans);
        answer = new String[ans.size()];
        for(int i=0;i< answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
