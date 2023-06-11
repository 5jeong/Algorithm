package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.Arrays;

public class 문서도난 {
    public static String[] solution(String[] reports, String times){
        String[] answer = {};

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

}
