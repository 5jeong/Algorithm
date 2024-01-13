package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 문서도난 {
    public static String[] solution(String[] reports, String times) {
        String[] answer = {};
        int startMinute = 0;
        int endMinute = 0;
        String startTime = times.split(" ")[0];
        String endTime = times.split(" ")[1];
        startMinute = calculateMinute(startTime);
        endMinute = calculateMinute(endTime);
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String x : reports) {
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            hashMap.put(name, calculateMinute(time));
        }
        List<String> temp = new LinkedList<>(hashMap.keySet());
        temp.sort(Comparator.comparing(hashMap::get));
        ArrayList<String> result = new ArrayList<>();
        for (String name : temp) {
            if (startMinute <= hashMap.get(name) && endMinute >= hashMap.get(name)) {
                result.add(name);
            }
        }
        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    static int calculateMinute(String time) {
        String a = time.split(":")[0];
        String b = time.split(":")[1];
        int minute = Integer.parseInt(a) * 60 + Integer.parseInt(b);
        return minute;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"},
                        "08:33 09:45")));
        System.out.println(Arrays.toString(solution(
                new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23",
                        "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(
                solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"},
                        "14:20 15:20")));
    }

}
