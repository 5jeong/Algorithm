package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 문서도난 {
    static class info implements Comparable<info>{

        String name;
        int time;
        info(String name, int time){
            this.name =name;
            this.time = time;
        }
        @Override
        public int compareTo(info o) {
            return this.time - o.time;
        }
    }
    static int getTimes(String time){
        int H = Integer.parseInt(time.split(":")[0]) * 60;
        int M = Integer.parseInt(time.split(":")[1]);
        return H+M;
    }
    public static String[] solution(String[] reports, String times){
        ArrayList<info> temp = new ArrayList<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            temp.add(new info(a,getTimes(b)));
        }
        Collections.sort(temp);
        int s = getTimes(times.split(" ")[0]);
        int e = getTimes(times.split(" ")[1]);
        ArrayList<String> res = new ArrayList<>();
        for(info x : temp){
            if(s <= x.time && e >= x.time){
                res.add(x.name);
            }
            if(e <= x.time){
                break;
            }
        }
        String[] answer = new String[res.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

}
